package com.deloitte.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.service.TUService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@RestController
public class TUController {
	private static final Logger logger = LoggerFactory.getLogger(TUController.class);
	@Autowired
	private TUService tuservice;

	@PostMapping(value = "/data", produces = { MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.ALL_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public String invokeTUCall(@RequestBody String obj) throws StreamReadException, DatabindException, IOException {
		logger.info("Inside invokeTUCall method *****");
		return tuservice.invokeTUCall(obj);
	}

}
