package com.giantlink.glintranet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.CommentRequest;
import com.giantlink.glintranet.requests.ReplyRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.ReplyResponse;
import com.giantlink.glintranet.services.CommentService;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CommentController {
	@Autowired
	CommentService commentService;
	
	
	@PostMapping
	public ResponseEntity<CommentResponse> addComment(@RequestBody @Valid CommentRequest request)
	{
		CommentResponse response = commentService.add(request);
		return new ResponseEntity<CommentResponse>(response,HttpStatus.CREATED);
	}
	
	@PostMapping("/reply")
	public ResponseEntity<ReplyResponse> addReply(@RequestBody @Valid ReplyRequest request)
	{
		return new ResponseEntity<ReplyResponse>(commentService.add(request), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CommentResponse>> getComments()
	{
		List<CommentResponse> responses = commentService.getAll();
		return new ResponseEntity<List<CommentResponse>>(responses, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommentResponse> get(@PathVariable Long id)
	{
		CommentResponse response = commentService.get(id);
		return new ResponseEntity<CommentResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CommentResponse> update(@PathVariable Long id, @RequestBody @Valid CommentRequest request)
	{
		CommentResponse response = commentService.update(id, request);
		return new ResponseEntity<CommentResponse>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		commentService.delete(id);
		return new ResponseEntity<String>("Tag deleted", HttpStatus.OK);
	}
}
