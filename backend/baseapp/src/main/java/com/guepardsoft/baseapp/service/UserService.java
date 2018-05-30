package com.guepardsoft.baseapp.service;

import com.guepardsoft.baseapp.domain.User;
import com.guepardsoft.baseapp.repository.UserRepository;
import com.guepardsoft.baseapp.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getUserById(String id){
        return userRepository.getUserByIdString(id);
    }


    public void addUser(UserController.UserRequestDTO newUserDTO){
        User newUser = new User();
        newUser.setUsername(newUserDTO.getUsername());
        newUser.setPassword(newUserDTO.getPassword());
        newUser.setFirstName(newUserDTO.getFirstName());
        newUser.setLastName(newUserDTO.getLastName());
        newUser.setGender(newUserDTO.getGender());
        newUser.setEmail(newUserDTO.getEmail());
        newUser.setStatus(newUserDTO.getStatus());
        userRepository.save(newUser);
        System.out.println("the Name of teacher is --->" + newUser.getUsername());
    }

    public void updateUser(User user){
        userRepository.save(user);
        System.out.println("Update user: " + user);
    }


    public void deleteUser(String id){
        User user = userRepository.getUserByIdString(id);
        userRepository.delete(user);
        System.out.println("Delete user: " + user);
    }

}
