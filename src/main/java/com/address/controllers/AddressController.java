package com.address.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.address.addressresponse.AddressResponse;
import com.address.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id) {

		AddressResponse addressResponse = addressService.findAddressByEmployeeId(id);

		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AddressResponse>> getAllAddress(){
		List<AddressResponse> all = this.addressService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}

}
