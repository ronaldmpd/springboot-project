package com.guepardsoft.baseapp.service;

import com.guepardsoft.baseapp.domain.Customer;
import com.guepardsoft.baseapp.repository.CustomerRepository;
import com.guepardsoft.baseapp.web.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getAllCustomers(){
    List<Customer> users = customerRepository.findAll();
    return users;
  }

  public Customer getCustomerById(String id){
    return customerRepository.getCustomerByIdString(id);
  }

  public void addCustomer(CustomerController.CustomerRequestDTO newUserDTO){
    Customer customer = new Customer();
    customer.setFirstName(newUserDTO.getFirstName());
    customer.setLastName(newUserDTO.getLastName());
    customer.setEmail(newUserDTO.getEmail());
    customer.setPhone(newUserDTO.getPhone());
    customer.setStatus(newUserDTO.getStatus());
    customerRepository.save(customer);
    System.out.println("Add customer --->" + customer);
  }

  public void updateCustomer(Customer customer){
    customerRepository.save(customer);
    System.out.println("Update customer: " + customer);
  }

  public void deleteCustomer(String id){
    Customer customer = customerRepository.getCustomerByIdString(id);
    customerRepository.delete(customer);
    System.out.println("Delete customer: " + customer);
  }

}
