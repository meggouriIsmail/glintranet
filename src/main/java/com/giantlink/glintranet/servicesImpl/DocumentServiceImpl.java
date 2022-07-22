package com.giantlink.glintranet.servicesImpl;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
	private  DocumentRepository documentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DocTypeRepository typeRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	

	@Override
	public void upload(MultipartFile file, Long empId, Long typeId) throws Exception 
	{
		Document document = new Document();		
		Optional<Employee> employee = employeeRepository.findById(empId);
		Optional<DocType> type  = typeRepository.findById(typeId);
		
		 try 
		 {
	            
			 	document.setDocumentName(StringUtils.cleanPath(file.getOriginalFilename()));
				document.setContentType(file.getContentType());
				document.setData(file.getBytes());
				document.setSize(file.getSize());
				document.setType(type.get());
				document.setEmployee(employee.get());
				
				documentRepository.save(document);
				
				sendEmail(document);
				
				//System.out.println(document.getDocumentName()+" "+document.getContentType()+" "+document.getCreationDate()+" "+
									//document.getData()+" "+document.getSize()+" "+document.getEmployee().getId());
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

	@Override
	public List<Document> getDocs() 
	{
		List<Document> documents = documentRepository.findAll();
		
		return documents;
	}

	@Override
	public Document getDoc(Long id) {
		Document document = documentRepository.findById(id).get();
		return document;
	}
	
	public void sendEmail(Document document) 
	{
		MimeMessage message = mailSender.createMimeMessage();
		Employee employee = employeeRepository.getById(document.getEmployee().getId());
		List<Employee> employees = employeeRepository.findAll();
		
		
		
		new Thread(() ->
		{
			for (Employee employe : employees) 
			{
				if(!(employe.getId() == employee.getId())) 
				{
					try
					{
						message.setFrom("${spring.mail.username}");
						message.addRecipients(Message.RecipientType.TO, employe.getEmail());
						
						String body = "Hello, "+ employe.getFirstName()+ " "+ employe.getLastName()+ "<br><br>"
								+ "<b>" +employee.getFirstName()+" "+employee.getLastName()+" </b> added a new document in the plateforme <br>"
										+ " check ASAP";
						
						message.setSubject("New Document");
						message.setText(body, "UTF-8", "html");
						
						mailSender.send(message);
						System.out.println("Mail sent succesfully");
		
					} catch (MessagingException e) 
					{
						System.out.println(" --------- *******- ---------- - - -- Mail Not Sent...");
						e.printStackTrace();
					}
				}
				}

			}).start();
		
	}
	
	

	
	

}
