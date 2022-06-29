package com.giantlink.glintranet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.FeedBackTypeRequest;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;
import com.giantlink.glintranet.services.FeedBackTypeService;

@RestController
@RequestMapping("/api/fbtype")
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
	
	@GetMapping("/{id}")
	public ResponseEntity<FeedBackTypeResponse> getType(@PathVariable Long id)
	{
		FeedBackTypeResponse response = typeService.get(id);
		return new ResponseEntity<FeedBackTypeResponse>(response, HttpStatus.OK);
 	}
	
	@GetMapping()
	public ResponseEntity<List<FeedBackTypeResponse>> getAllTypes()
	{
		List<FeedBackTypeResponse> responses = typeService.getAll();
		return new ResponseEntity<List<FeedBackTypeResponse>>(responses,HttpStatus.OK);
	}
}
