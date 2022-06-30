package com.giantlink.glintranet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.FeedBackTypeRequest;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;
import com.giantlink.glintranet.services.FeedBackTypeService;

@RestController
@RequestMapping("/api/fbtype")
@CrossOrigin(origins = { "http://localhost:4200" })
public class FeedBackTypeController 
{
	@Autowired
	FeedBackTypeService typeService;
	
	@PostMapping
	public ResponseEntity<FeedBackTypeResponse> addType(@RequestBody FeedBackTypeRequest request)
	{
		FeedBackTypeResponse response = typeService.add(request);
		return new ResponseEntity<FeedBackTypeResponse>(response, HttpStatus.OK);
		
	}
}
