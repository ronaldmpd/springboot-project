package com.guepardsoft.baseapp.web;


import com.guepardsoft.baseapp.domain.Customer;
import com.guepardsoft.baseapp.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Api(value="onlinestore", description="Operations pertaining to customers in Online Store")

public class CustomerController {

  @Autowired
  CustomerService customerService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Customer> getAllCustomers(){
    return customerService.getAllCustomers();
  }

  @RequestMapping(path="/{id}",method = RequestMethod.GET)
  public Customer getCustomerById(@PathVariable String id){
    return customerService.getCustomerById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public void addCustomer(@RequestBody CustomerRequestDTO newCustomerDTO){
    customerService.addCustomer(newCustomerDTO);
  }

  @RequestMapping(method = RequestMethod.PATCH)
  public void updateCustomer(@RequestBody Customer newCustomer){
    customerService.updateCustomer(newCustomer);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void deleteUser(@PathVariable String id){
    customerService.deleteCustomer(id);
  }


  public static class CustomerRequestDTO{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Boolean status;

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public Boolean getStatus() {
      return status;
    }

    public void setStatus(Boolean status) {
      this.status = status;
    }

    @Override
    public String toString() {
      return "CustomerRequestDTO{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", status=" + status +
        '}';
    }
  }

}
