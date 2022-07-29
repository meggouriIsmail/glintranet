package com.giantlink.glintranet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByEmployee(Employee employee);
}
