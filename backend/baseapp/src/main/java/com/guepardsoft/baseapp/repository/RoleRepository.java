package com.guepardsoft.baseapp.repository;

import com.guepardsoft.baseapp.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RoleRepository extends MongoRepository<Role, String> {
    @Query("{id: ?0}")
    Role getRoleByIdString(String id);
}