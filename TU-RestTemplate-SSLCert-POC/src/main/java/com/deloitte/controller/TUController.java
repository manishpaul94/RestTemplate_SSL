package com.deloitte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.pojo.TUPojo;
import com.deloitte.service.TUService;
@RestController
public class TUController {
	
	@Autowired
	private TUService tuservice;
	
	@GetMapping("/getTU")
	public TUPojo invokeTUCall() {
		return tuservice.invokeTUCall();
	}


}
