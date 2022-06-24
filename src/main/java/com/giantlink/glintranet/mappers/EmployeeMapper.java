package com.giantlink.glintranet.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResponse;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

	Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);

	EmployeeResponse employeeToEmployeeResponse(Employee employee);

	List<EmployeeResponse> mapEmployee(List<Employee> employees);

	Set<EmployeeResponse> mapEmployee(Set<Employee> employees);
	
	Set<Employee> mapEmployeeRequest(Set<EmployeeRequest> employees);
	

	List<EmployeeResSimplified> mapEmployeeSimplified(List<Employee> employees);

	Set<EmployeeResSimplified> mapEmployeeSimplified(Set<Employee> employees);
}
