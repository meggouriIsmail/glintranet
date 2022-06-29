package com.giantlink.glintranet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.glintranet.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	Optional<Employee> findByCIN(String cin);
	Optional<Employee> findByFirstName(String firstName);
	Optional<Employee> findByLastName(String lastName);
	Optional<Employee> findByEmail(String email);
	
}
