package com.giantlink.glintranet.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResponse;

@Mapper(componentModel = "spring")
public interface EmployeeMapper 
{
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);
	EmployeeResponse employeeToEmployeeResponse(Employee employee);
	
	List<EmployeeResponse> mapEmployee(List<Employee> employees);
}
