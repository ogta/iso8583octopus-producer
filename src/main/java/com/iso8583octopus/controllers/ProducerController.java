package com.iso8583octopus.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iso8583octopus.services.Producer;

@RestController
@RequestMapping("/switch/v1")
public class ProducerController {

	@Autowired
	private Producer producer;

	@PostMapping("/")
	public ResponseEntity<HashMap<String, Object>> produce(@RequestBody HashMap<String, Object> request) {
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		producer.sendMessage(request.get("message").toString());
		response.put("responseCode", "00");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
