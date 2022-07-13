package com.giantlink.glintranet.controllers;

import java.util.ArrayList;
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

import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResponse;
import com.giantlink.glintranet.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = { "http://localhost:4200" })

public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeResSimplified>> getEmployees()
	{
		List<EmployeeResSimplified> list = new ArrayList<>();
		list = employeeService.getAll();
		return new ResponseEntity<List<EmployeeResSimplified>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResSimplified> getEmployee(@PathVariable Long id)
	{
		EmployeeResSimplified emp = employeeService.get(id);
		return new ResponseEntity<EmployeeResSimplified>(emp,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) throws Exception
	{
		EmployeeResponse newEmp = employeeService.add(employeeRequest);
		return new ResponseEntity<EmployeeResponse>(newEmp, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> editEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest)
	{
		return new ResponseEntity<EmployeeResponse>(employeeService.update(id, employeeRequest),HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id)
	{
		employeeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
