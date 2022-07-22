package com.giantlink.glintranet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.glintranet.entities.EmployeeFAQ;
import com.giantlink.glintranet.entities.EmployeeFaqId;

@Repository
public interface EmployeeFaqRepository extends JpaRepository<EmployeeFAQ, EmployeeFaqId>
{

}
