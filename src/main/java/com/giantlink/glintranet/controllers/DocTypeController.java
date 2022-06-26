package com.giantlink.glintranet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.DocTypeRequest;
import com.giantlink.glintranet.responses.DocTypeResponse;
import com.giantlink.glintranet.services.DocTypeService;

@RestController
@RequestMapping("/api/type")
public class DocTypeController 
{
	@Autowired
	DocTypeService typeService;
	
	@PostMapping
	public ResponseEntity<DocTypeResponse> addType(@RequestBody @Valid DocTypeRequest request)
	{
		DocTypeResponse response = typeService.add(request);
		return new ResponseEntity<DocTypeResponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<DocTypeResponse>> getTypes()
	{
		List<DocTypeResponse> list = typeService.getAll();
		return new ResponseEntity<List<DocTypeResponse>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DocTypeResponse> getType(@PathVariable Long id)
	{
		DocTypeResponse response = typeService.get(id);
		return new ResponseEntity<DocTypeResponse>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteType(@PathVariable Long id)
	{
		typeService.delete(id);
		return new ResponseEntity<String>("DELETED",HttpStatus.OK);
	}
}
