package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.request.FlightServiceRequest;

@RestController
@RequestMapping("gateway/flight")
public class FlightController {
	
	@Autowired
	private FlightServiceRequest flightServiceRequest;
	
	@PostMapping
	public ResponseEntity<?> addFlight(@RequestBody Object flight){
		return new ResponseEntity<>(flightServiceRequest.addFlight(flight), HttpStatus.CREATED);
	}
	
	@GetMapping("/allFlight")
	public ResponseEntity<?> viewAllFlight(){
		return new ResponseEntity<>(flightServiceRequest.viewAllFlight(), HttpStatus.OK);
	}
		
	

	@GetMapping("/viewFlight/{id}")
	public ResponseEntity<?> viewFlight(@PathVariable("id") BigInteger flightNo){
	return new ResponseEntity<>(flightServiceRequest.viewFlight(flightNo), HttpStatus.OK);
	}

	@PutMapping("/updateFlight")
	public ResponseEntity<?> modifyFlight(@RequestBody Object requestBody){
		flightServiceRequest.modifyFlight(requestBody);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteFlight/{id}")
	public ResponseEntity<?> removeFlight(@PathVariable("id") BigInteger flightNo){
		flightServiceRequest.removeFlight(flightNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
	

}
