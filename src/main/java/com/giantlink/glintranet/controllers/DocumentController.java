package com.giantlink.glintranet.controllers;


import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.giantlink.glintranet.entities.Document;
import com.giantlink.glintranet.requests.DocumentRequest;
import com.giantlink.glintranet.services.DocumentService;

@RestController
@RequestMapping("/api/document")
public class DocumentController 
{
	@Autowired
	DocumentService documentService;
	
	@PostMapping("/{empId}/{typeId}")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, @PathVariable Long empId, @PathVariable Long typeId) throws Exception
	{
		documentService.upload(file, empId, typeId);
		return new ResponseEntity<String>("File Uploaded successfully",HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> downloadDoc(@PathVariable Long id)
	{
		System.out.print("Entered");
		Optional<Document> foundDocument = documentService.download(id);
		Document document = foundDocument.get();
		
		return ResponseEntity.ok()
							 .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,  "attachment; filename=\"" + document.getDocumentName() + "\"")
							 .contentType(MediaType.valueOf(document.getContentType()))
							 .body(document.getData());
	}
}
