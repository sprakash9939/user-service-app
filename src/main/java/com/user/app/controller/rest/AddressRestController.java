package com.user.app.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressRestController {
	
	@GetMapping(value = "/get-address")
	public ResponseEntity<?> getAddress(){
		
		String address = "this address is from bangalore";
		return ResponseEntity.ok(address);
	}

}
