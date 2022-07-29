package com.giantlink.glintranet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.responses.NotificationResponse;
import com.giantlink.glintranet.services.NotificationService;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin(origins = { "http://localhost:4200" })
public class NotificationController {

	@Autowired
	NotificationService notificationService;

	@GetMapping("/{id}")
	public ResponseEntity<List<NotificationResponse>> getNotifications(@PathVariable Long id )
	{
		List<NotificationResponse> responses = notificationService.getAllNotifications(id);
		return new ResponseEntity<List<NotificationResponse>>(responses, HttpStatus.OK);
	}
}
