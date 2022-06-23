package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.mappers.EmployeeMapper;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResponse;
import com.giantlink.glintranet.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeMapper mapper;
	
	
	@Override
	public EmployeeResponse add(EmployeeRequest employeeRequest) {
		Optional<Employee> findEmployee = employeeRepository.findByCIN(employeeRequest.getCIN());
		
		if(findEmployee.isPresent()) 
		{	throw new NonUniqueResultException(Employee.class.getSimpleName()+ " already exist"); }
		
		Employee newEmployee = null ;
		newEmployee = Employee.builder().firstName(employeeRequest.getFirstName())
										.lastName(employeeRequest.getLastName())
										.CIN(employeeRequest.getCIN())
										.username(employeeRequest.getUsername())
										.email(employeeRequest.getPassword())
										.password(employeeRequest.getPassword())
										.phoneNumber(employeeRequest.getPhoneNumber())
										.birthDate(employeeRequest.getBirthDate())
										.build();
		employeeRepository.save(newEmployee);
		return mapper.employeeToEmployeeResponse(newEmployee);
		
	}

	@Override
	public EmployeeResponse get(Long id) {
		
		return	mapper.employeeToEmployeeResponse(employeeRepository.findById(id).get());
	}

	@Override
	public List<EmployeeResponse> getAll() {
		List<EmployeeResponse> allEmployees = new ArrayList<EmployeeResponse>();
		employeeRepository.findAll().forEach(emp -> allEmployees.add(mapper.employeeToEmployeeResponse(emp)));
		return allEmployees;
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
		Optional<Employee> upEmployee = employeeRepository.findById(id);
		if(upEmployee.isEmpty())
		{ throw new NoSuchElementException("employee doesn't exisit");	}
		
		Employee emp = employeeRepository.getById(id);
		emp.setFirstName(employeeRequest.getFirstName());
		emp.setLastName(employeeRequest.getLastName());
		emp.setUsername(employeeRequest.getUsername());
		emp.setEmail(employeeRequest.getEmail());
		emp.setPassword(employeeRequest.getPassword());
		emp.setPhoneNumber(employeeRequest.getPhoneNumber());
		employeeRepository.save(emp);
		
		return mapper.employeeToEmployeeResponse(emp);
	}

}