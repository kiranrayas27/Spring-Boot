package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.entity.Customer;
import com.msedcl.main.customer.exception.CustomerNotFoundException;
import com.msedcl.main.customer.mapper.CustomerMapper;
import com.msedcl.main.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
		Customer customer=CustomerMapper.toEntity(customerRequestDTO);
		Customer savedCustomer=customerRepository.save(customer);
		return CustomerMapper.toDTO(savedCustomer);
	}

	@Override
	public CustomerResponseDTO getCustomerByCustomerId(int customerId) {
		Optional<Customer> customer=customerRepository.findByCustomerId(customerId);
		if(customer.isPresent()) {
			CustomerResponseDTO customerResponseDTO=CustomerMapper.toDTO(customer.get());
			return customerResponseDTO;
		}
		throw new CustomerNotFoundException("Invalid CustomerId :: "+customerId);
	}
	
	@Override
	public CustomerResponseDTO getCustomerByEmail(String email) {
		Optional<Customer> customer=customerRepository.findByEmail(email);
		if(customer.isPresent()) {
			CustomerResponseDTO customerResponseDTO=CustomerMapper.toDTO(customer.get());
			return customerResponseDTO;
		}
		throw new CustomerNotFoundException("Invalid Customer Email ID :: "+email);
	}

	@Override
	public List<CustomerResponseDTO> getAllCustomers() {
		List<Customer> customerList=customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOs=new ArrayList<>();
		
		for(Customer customer : customerList)
			customerResponseDTOs.add(CustomerMapper.toDTO(customer));
		
		return customerResponseDTOs;
	}

	
	
	

}
