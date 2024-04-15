package com.address.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.address.addressresponse.AddressResponse;
import com.address.entities.Address;
import com.address.repo.AddressRepo;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private ModelMapper mapper;

	public AddressResponse findAddressByEmployeeId(int employeeId) {
		Address address = this.addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse = this.mapper.map(address, AddressResponse.class);
		return addressResponse;
	}

	public List<AddressResponse> getAll() {
		List<Address> allAddresses = this.addressRepo.findAll();
		return allAddresses.stream().map(address -> mapper.map(address, AddressResponse.class))
				.collect(Collectors.toList());
	}

}
