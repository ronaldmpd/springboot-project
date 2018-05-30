package com.guepardsoft.baseapp.repository;

import com.guepardsoft.baseapp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{username: ?0, password:?1 }")
    User getUserByUsernameAndPassword(String username, String password);

    @Query("{id: ?0}")
    User getUserByIdString(String id);
}

