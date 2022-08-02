package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.EmployeeNotification;
import com.giantlink.glintranet.entities.Notification;
import com.giantlink.glintranet.mappers.NotificationMapper;
import com.giantlink.glintranet.repositories.EmployeeNotificationRepository;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.NotificationRepository;
import com.giantlink.glintranet.requests.NotificationRequest;
import com.giantlink.glintranet.responses.NotificationResponse;
import com.giantlink.glintranet.services.NotificationService;

@Service
public class NotificationServiceImp implements NotificationService {

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	EmployeeNotificationRepository employeeNotificationRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Notification> notifyAll(NotificationRequest request) {
		Optional<Employee> optionalEmp = employeeRepository.findById(request.getEmpl_id());
		List<Employee> employees = employeeRepository.findAll();

		List<Notification> notifs = new ArrayList<>();

		employees.forEach(emp -> {
			if (!(optionalEmp.get().getId() == emp.getId())) {
				Notification notification = Notification.builder().content(request.getContent()).employee(emp)
						.link(request.getLink()).isRead(false).build();
				notifs.add(notificationRepository.save(notification));
			}
		});

		return notifs;
	}

	@Override
	public Notification notifyOne(NotificationRequest request, Employee receiver) {

		Notification notification = Notification.builder().content(request.getContent()).employee(receiver)
				.link(request.getLink()).isRead(false).build();

		return notificationRepository.save(notification);
	}

	@Override
	public void add(EmployeeNotification employeeNotification) {
		employeeNotificationRepository.save(employeeNotification);
	}

	@Override
	public List<NotificationResponse> getAllNotifications(Long employeeId) {
		Employee employee = employeeRepository.getById(employeeId);
		return NotificationMapper.INSTANCE.toResponses(notificationRepository.findByEmployeeAndIsRead(employee, false));
	}

	@Override
	public void readAllNotifications(Long employeeId) {
		Employee employee = employeeRepository.getById(employeeId);
		
		notificationRepository.findByEmployee(employee).forEach(notif -> {
			if (!notif.getIsRead()) {
				notif.setIsRead(true);
				notificationRepository.save(notif);
			}
		});

	}

	@Override
	public void readNotification(Long id) {
		Notification notification = notificationRepository.getById(id);
		notification.setIsRead(true);
		notificationRepository.save(notification);
	}

}
