package com.giantlink.glintranet.servicesImpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.giantlink.glintranet.entities.DocType;
import com.giantlink.glintranet.entities.Document;
import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.repositories.DocTypeRepository;
import com.giantlink.glintranet.repositories.DocumentRepository;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.requests.DocumentRequest;
import com.giantlink.glintranet.services.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService 
{
	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DocTypeRepository typeRepository;

	@Override
	public void upload(MultipartFile file, Long empId, Long typeId) throws Exception 
	{
		Document document = new Document();		
		Employee employee = employeeRepository.getById(empId);
		DocType type  = typeRepository.getById(typeId);
		 try 
		 {
	            
			 	document.setDocumentName(StringUtils.cleanPath(file.getOriginalFilename()));
				document.setContentType(file.getContentType());
				document.setData(file.getBytes());
				document.setSize(file.getSize());
				document.setType(type);
				document.setEmployee(employee);
				
				documentRepository.save(document);
				
				System.out.println(document.getDocumentName()+" "+document.getContentType()+" "+document.getCreationDate()+" "+
									document.getData()+" "+document.getSize()+" "+document.getEmployee().getId());
	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + document.getDocumentName());
	       }
		System.out.println("document "+document.getDocumentName()+" uploaded succesfully");
		
		
	}

	@Override
	public Optional<Document> download(Long id) {
		// TODO Auto-generated method stub
		return documentRepository.findById(id);
	}

	

}
