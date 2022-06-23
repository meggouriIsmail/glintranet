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

import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.FAQResponse;
import com.giantlink.glintranet.services.FAQService;

@RestController
@RequestMapping("/api/faq")
public class FAQController 
{
	@Autowired
	FAQService faqService;
	
	@PostMapping
	public ResponseEntity<FAQResponse> add(@RequestBody @Valid FAQRequest faqRequest)
	{
		FAQResponse response = faqService.addFaq(faqRequest);
		return new ResponseEntity<FAQResponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<FAQResponse>> getAll()
	{
		List<FAQResponse> response = faqService.getAll();
		return new ResponseEntity<List<FAQResponse>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<FAQResponse> getFAQ(@PathVariable Long id)
	{
		FAQResponse response = faqService.getFaq(id);
		return new ResponseEntity<FAQResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FAQResponse> updateFAQ(@PathVariable Long id, @RequestBody @Valid FAQRequest request)
	{
		FAQResponse response = faqService.editFaq(id, request);
		return new ResponseEntity<FAQResponse>(response,HttpStatus.OK);
	}
	
	
	@PutMapping("/up/{id}")
	public ResponseEntity<FAQResponse> voteUp(@PathVariable Long id)
	{
		FAQResponse response = faqService.voteUp(id);
		return new ResponseEntity<FAQResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping("/down/{id}")
	public ResponseEntity<?> voteDown(@PathVariable Long id)
	{
		faqService.voteDown(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFAQ(@PathVariable Long id)
	{
		faqService.deleteFaq(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
