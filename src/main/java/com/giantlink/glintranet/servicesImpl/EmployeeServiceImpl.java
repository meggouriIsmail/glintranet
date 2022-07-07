package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.mappers.EmployeeMapper;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.RoleRepository;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResponse;
import com.giantlink.glintranet.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeMapper mapper;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	
	
	@Override
	public EmployeeResponse add(EmployeeRequest employeeRequest) {
		Optional<Employee> findEmployee = employeeRepository.findByCIN(employeeRequest.getCIN());
		
		if(findEmployee.isPresent()) 
		{	throw new NonUniqueResultException(Employee.class.getSimpleName()+ " already exist"); }
		
		Set<Role> roles = new HashSet<Role>();
		
		employeeRequest.getRoles().forEach(role -> {
			Optional<Role> optional = roleRepository.findByName(role.getName());
			
			if (optional.isPresent()) roles.add(optional.get());
		});
		
		Employee newEmployee = Employee.builder().firstName(employeeRequest.getFirstName())
										.lastName(employeeRequest.getLastName())
										.CIN(employeeRequest.getCIN())
										.username(employeeRequest.getUsername())
										.email(employeeRequest.getEmail())
										.password(bCryptPasswordEncoder.encode(employeeRequest.getPassword()))
										.phoneNumber(employeeRequest.getPhoneNumber())
										.birthDate(employeeRequest.getBirthDate())
										.roles(roles)
										.build();
		
		return mapper.employeeToEmployeeResponse(employeeRepository.save(newEmployee));
		
	}

	@Override
	public EmployeeResSimplified get(Long id) {
		
		return	mapper.toEmployeeSimplified(employeeRepository.findById(id).get());
	}

	@Override
	public List<EmployeeResSimplified> getAll() {
		List<EmployeeResSimplified> allEmployees = new ArrayList<EmployeeResSimplified>();
		employeeRepository.findAll().forEach(emp -> allEmployees.add(mapper.toEmployeeSimplified(emp)));
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

	@Override
	public EmployeeResponse get(String email) {
		return	mapper.employeeToEmployeeResponse(employeeRepository.findByEmail(email).get());
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Employee> emp = employeeRepository.findByEmail(email);
		if(emp.isEmpty()) throw new NoSuchElementException("email is invalid");
		return new User(emp.get().getEmail(), emp.get().getPassword(), new ArrayList<>());
	}

	@Override
	public void purge() {
		employeeRepository.deleteAll();
		
	}


}
