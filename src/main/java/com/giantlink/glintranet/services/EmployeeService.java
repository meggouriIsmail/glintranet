package com.giantlink.glintranet.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResponse;

public interface EmployeeService extends UserDetailsService {
	EmployeeResponse add(EmployeeRequest employeeRequest);

	EmployeeResSimplified get(Long id);

	List<EmployeeResSimplified> getAll();

	void delete(Long id);

	EmployeeResponse update(Long id, EmployeeRequest employeeRequest);

	EmployeeResponse get(String email);

	void purge();
}
