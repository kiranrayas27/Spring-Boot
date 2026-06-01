package com.msedcl.main.customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.customer.common.ApiResponse;
import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@Slf4j
@RestController
@RequestMapping("customerapi")
@AllArgsConstructor
//constructor injection
public class CustomerController {

	private final CustomerService customerService;
	
	@PostMapping("customers/customer")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> addNewCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO){
		
		//console
		log.info("Request received to add new customer");
		log.info(customerRequestDTO.toString());
		
		CustomerResponseDTO customerResponseDTO=customerService.createCustomer(customerRequestDTO);
		
		
		//console
		log.info("New customer added successfully.");
		log.info(customerResponseDTO.toString());
		
		
		//Response
		ApiResponse<CustomerResponseDTO> apiResponse=new ApiResponse<CustomerResponseDTO>("CREATED","New Customer created successfully", customerResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}
	
	
	@GetMapping("customers/{customer}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerById(@PathVariable int customer){
		
		//console
		log.info("Getting customer By Id.."+customer);
		
		CustomerResponseDTO customerResponseDTO=customerService.getCustomerByCustomerId(customer);
		
		
		//console
		log.info("find response generated");
		log.info(customerResponseDTO.toString());
		
		
		//Response
		ApiResponse<CustomerResponseDTO> apiResponse=new ApiResponse<CustomerResponseDTO>("FOUND","Customer Found by the controller", customerResponseDTO);
		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
	}
	
	@GetMapping("customers/email/{email}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerByEmail(@PathVariable String email){
		
		//console
		log.info("Getting customer By Email.."+email);
		
		CustomerResponseDTO customerResponseDTO=customerService.getCustomerByEmail(email);
		
		
		//console
		log.info("find response generated");
		log.info(customerResponseDTO.toString());
		
		
		//Response
		ApiResponse<CustomerResponseDTO> apiResponse=new ApiResponse<CustomerResponseDTO>("FOUND","Customer Found by the controller", customerResponseDTO);
		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
	}
	
	@GetMapping("customers")
	public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getAllCustomers(){
		log.info("Request recieved to retrieve all customers");
		List<CustomerResponseDTO> customerResponseDTOList=customerService.getAllCustomers();
		log.info("All customers retrieved successfully.");
		
		//Response
		ApiResponse<List<CustomerResponseDTO>> apiResponse=new ApiResponse<List<CustomerResponseDTO>>("FOUND","Customer List retrieved", customerResponseDTOList);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
}
