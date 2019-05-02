package com.lunchmanager.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressController {


		@Autowired
		private AddressService addressService;
		
		@RequestMapping(method=RequestMethod.POST, value="/addaddress")
		public void addAddress(@RequestBody Address address ) {
			addressService.addAddress(address);
		}
		
		@RequestMapping("/addresses")	
		public List<Address> getAllAddresses(){
			return addressService.getAllAddresses();
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/updateaddress/{id}")
		public void updateAddressData(@RequestBody Address address, @PathVariable Long id) {
			addressService.updateAddressData(address);
		}
}
