package com.giantlink.glintranet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.responses.FAQResponse;
import com.giantlink.glintranet.responses.ReportingResponse;
import com.giantlink.glintranet.services.ReportingService;

@RestController
@RequestMapping("/api/reporting")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ReportingController 
{
	@Autowired
	ReportingService reportingService;

	@GetMapping
	public ResponseEntity<ReportingResponse> getAll()
	{
		ReportingResponse response = reportingService.getReports();
		return new ResponseEntity<ReportingResponse>(response, HttpStatus.OK);
	}
}
