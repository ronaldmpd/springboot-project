package com.guepardsoft.baseapp.repository;

import com.guepardsoft.baseapp.domain.Role;
import com.guepardsoft.baseapp.domain.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserRoleRepository extends MongoRepository<UserRole, String> {

}
