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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.SectionRequest;
import com.giantlink.glintranet.responses.SectionResponse;
import com.giantlink.glintranet.services.SectionService;

@RestController
@RequestMapping("/api/section")
public class SectionController 
{
	@Autowired
	SectionService sectionService;
	
	
	@GetMapping
	public ResponseEntity<List<SectionResponse>> getAllSections()
	{
		List<SectionResponse> sectionsList = sectionService.getAll();
		return new ResponseEntity<List<SectionResponse>>(sectionsList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SectionResponse> getSection(@PathVariable Long id)
	{
		SectionResponse response = sectionService.get(id);
		return new ResponseEntity<SectionResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<SectionResponse> addSection(@RequestBody @Valid SectionRequest request)
	{
		SectionResponse newSection = sectionService.add(request);
		return new ResponseEntity<SectionResponse>(newSection, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SectionResponse> editSection(@PathVariable Long id, @RequestBody @Valid SectionRequest request)
	{
		SectionResponse response = sectionService.update(id, request);
		return new ResponseEntity<SectionResponse>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSection(@PathVariable Long id)
	{
		sectionService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);  
	}
}
