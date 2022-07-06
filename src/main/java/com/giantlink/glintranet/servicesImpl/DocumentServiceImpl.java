package com.giantlink.glintranet.servicesImpl;

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
		Optional<Employee> employee = employeeRepository.findById(empId);
		Optional<DocType> type  = typeRepository.findById(typeId);
		
		/*
		 * if(!employee.isEmpty()) { throw new
		 * NoSuchElementException(Employee.class.getSimpleName()+" doesnt exist"); }
		 * 
		 * if(!type.isPresent()) { throw new
		 * NoSuchElementException(DocType.class.getSimpleName()+" doesnt exist"); }
		 */
		
		
		 try 
		 {
	            
			 	document.setDocumentName(StringUtils.cleanPath(file.getOriginalFilename()));
				document.setContentType(file.getContentType());
				document.setData(file.getBytes());
				document.setSize(file.getSize());
				document.setType(type.get());
				document.setEmployee(employee.get());
				
				documentRepository.save(document);
				
				System.out.println(document.getDocumentName()+" "+document.getContentType()+" "+document.getCreationDate()+" "+
									document.getData()+" "+document.getSize()+" "+document.getEmployee().getId());
	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + document.getDocumentName()+"   ---- "+e.getMessage());
	       }
		System.out.println("document "+document.getDocumentName()+" uploaded succesfully");
		
		
	}

	@Override
	public Document download(Long id) throws Exception {
		
		return documentRepository.findById(id).orElseThrow(
				() -> new Exception("File not found with Id "+ id));
	}

	
	

}
