package com.giantlink.glintranet.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResponse;

public interface EmployeeService extends UserDetailsService
{
	EmployeeResponse add(EmployeeRequest employeeRequest);
	EmployeeResponse get(Long id);
	List<EmployeeResponse> getAll();
	void delete(Long id);
	EmployeeResponse update(Long id, EmployeeRequest employeeRequest);
	EmployeeResponse get(String email);
	void purge();
}
