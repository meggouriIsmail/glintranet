package com.giantlink.glintranet.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.giantlink.glintranet.entities.Document;
import com.giantlink.glintranet.requests.DocumentRequest;

public interface DocumentService 
{
	void upload(MultipartFile file, Long empId, Long typeId) throws Exception;
	
	Document download(Long id) throws Exception;
	
}
