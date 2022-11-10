package com.javainuse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@Slf4j
class ELKController {
	private final ELKService service;

	private final RestService restService;

	@GetMapping(value = "/hello")
	public String helloWorld() {
		log.info("Inside Hello World Function");
		String response = "Hello World! " + new Date();
		log.info("Response => {}", response);
		return response;
	}

	@RequestMapping(value = "/exception")
	public String exception() {
		String response = "";
		try {
			throw new Exception("Opps Exception raised....");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(String.valueOf(e));

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			log.error("Exception - " + stackTrace);
			response = stackTrace;
		}

		return response;
	}


	@GetMapping(value = "/Food-Details")
	public JSONArray foodDetails() {
		log.info("Inside Food Detail Function");
		return service.getAllFoodDetails();
	}
	
}
