package com.lunchmanager.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public Address findById(Long id) {
		return addressRepository.findAllById(id);
	}
	
	public List<Address> getAllAddresses(){
		List<Address> addresses=new ArrayList<>();
		addressRepository.findAll().forEach(addresses::add);
		return addresses;
	}

	public void updateAddressData(Address address) {
		addressRepository.save(address);
		
	}
}
