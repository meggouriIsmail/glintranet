package com.giantlink.glintranet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.glintranet.entities.EmpNotifId;
import com.giantlink.glintranet.entities.EmployeeNotification;

@Repository
public interface EmployeeNotificationRepository extends JpaRepository<EmployeeNotification, EmpNotifId> {

}
