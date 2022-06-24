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

import com.giantlink.glintranet.requests.TagRequest;
import com.giantlink.glintranet.responses.TagResponse;
import com.giantlink.glintranet.services.TagService;

@RestController
@RequestMapping("/api/tag")
public class TagController 
{
	@Autowired
	TagService tagService;
	
	
	@PostMapping
	public ResponseEntity<TagResponse> addTag(@RequestBody @Valid TagRequest request)
	{
		TagResponse response = tagService.add(request);
		return new ResponseEntity<TagResponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<TagResponse>> getTags()
	{
		List<TagResponse> responses = tagService.getAll();
		return new ResponseEntity<List<TagResponse>>(responses, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TagResponse> get(@PathVariable Long id)
	{
		TagResponse response = tagService.get(id);
		return new ResponseEntity<TagResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TagResponse> update(@PathVariable Long id, @RequestBody @Valid TagRequest request)
	{
		TagResponse response = tagService.update(id, request);
		return new ResponseEntity<TagResponse>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		tagService.delete(id);
		return new ResponseEntity<String>("Tag deleted", HttpStatus.OK);
	}
	
}
