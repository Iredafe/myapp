package com.dafe.spring.applogger.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dafe.spring.applogger.dao.UserLogDAO;
import com.dafe.spring.applogger.entity.UserLog;
import com.dafe.spring.applogger.service.UserLogService;

@RestController
@RequestMapping("/api")
public class UserLogRestController {
	
		private UserLogService userLogService;
	
	//inject logDao using constructor injection
		@Autowired
	public UserLogRestController(UserLogService theUserLogService) {
		
			userLogService = theUserLogService;
	}

	//expose logs and return list of logs
	@GetMapping("/userLog")
	public List<UserLog> findAll(){
		
		return userLogService.findAll();
	}

	
	//add mapping for GET userLog/{UserId}
		
	@GetMapping("/userLog/{userId}")
	public UserLog getUserLog(@PathVariable String userId) {
		
		UserLog theUserLog = userLogService.findById(userId);
		if (theUserLog==null) {
			throw new RuntimeException("User Id not found - " + userId);
			}
	return theUserLog;	
	}
	}
	

