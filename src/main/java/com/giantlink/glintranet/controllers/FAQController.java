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

import com.giantlink.glintranet.entities.EmployeeFAQ;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.FAQResponse;
import com.giantlink.glintranet.services.FAQService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/faq")
@CrossOrigin(origins = { "http://localhost:4200" })
@Tag(name = "FAQ", description = "Endpoints for managing FAQs")
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

	@GetMapping("section/{sectionId}")
	@Operation(
			summary = "Find a FAQ",
			description = "Find a FAQ by its Id",
			tags = {"FAQ"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = FAQ.class))
							
							),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
			)
	public ResponseEntity<List<FAQResponse>> getAll(@PathVariable @Parameter(description = "The id of section that contains the FAQs") Long sectionId)
	{
		List<FAQResponse> response = faqService.getAllBySection(sectionId);
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
	
	
	@GetMapping("/up/{id}")
	public ResponseEntity<FAQResponse> voteUp(@PathVariable Long id)
	{
		FAQResponse response = faqService.voteUp(id);
		return new ResponseEntity<FAQResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/down/{id}")
	public ResponseEntity<?> voteDown(@PathVariable Long id)
	{
		return new ResponseEntity<>(faqService.voteDown(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFAQ(@PathVariable Long id)
	{
		faqService.deleteFaq(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/vote/{empId}/{faqId}")
	public ResponseEntity<EmployeeFAQ> faqVote(@PathVariable Long empId, @PathVariable Long faqId)
	{
		EmployeeFAQ employeeFAQ =  faqService.faqVote(empId, faqId);
		return new ResponseEntity<EmployeeFAQ>(employeeFAQ, HttpStatus.OK);
	}
}
