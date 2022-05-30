package com.org.request;

import java.math.BigInteger;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(value = "flight-service"//Name of course-service application
, path = "/api/flight"//Pre-path for course-service
//,url = "${flight.service.url}"
,configuration = FeignConfiguration.class
)
public interface FlightServiceRequest {
	
	@PostMapping("/addFlight")
	Object addFlight(@RequestBody Object requestBody);
		
	

	@GetMapping("/allFlight")
	public Iterable<Object> viewAllFlight();
		
	

	@GetMapping("/viewFlight/{id}")
	public Object viewFlight(@PathVariable("id") BigInteger flightNo);
	
	

	@PutMapping("/updateFlight")
	 void modifyFlight(@RequestBody Object requestBody);

	@DeleteMapping("/deleteFlight/{id}")
	 void removeFlight(@PathVariable("id") BigInteger flightNo);
		

}
