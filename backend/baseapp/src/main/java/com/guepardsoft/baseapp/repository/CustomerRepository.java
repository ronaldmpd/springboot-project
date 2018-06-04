package com.guepardsoft.baseapp.repository;


import com.guepardsoft.baseapp.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer, String> {
  @Query("{id: ?0}")
  Customer getCustomerByIdString(String id);
}
