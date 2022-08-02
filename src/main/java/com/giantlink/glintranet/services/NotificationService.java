package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.EmployeeNotification;
import com.giantlink.glintranet.entities.Notification;
import com.giantlink.glintranet.requests.NotificationRequest;
import com.giantlink.glintranet.responses.NotificationResponse;

public interface NotificationService {
	List<Notification> notifyAll(NotificationRequest request);
	
	void add(EmployeeNotification employeeNotification);

	Notification notifyOne(NotificationRequest request, Employee receiver);
	
	List<NotificationResponse> getAllNotifications(Long employeeId);
	
	void readAllNotifications(Long empId);
	
	void readNotification(Long id);
}
