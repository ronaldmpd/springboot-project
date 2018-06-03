package com.guepardsoft.baseapp.service;

import com.guepardsoft.baseapp.domain.Role;
import com.guepardsoft.baseapp.domain.User;
import com.guepardsoft.baseapp.repository.RoleRepository;
import com.guepardsoft.baseapp.repository.UserRepository;
import com.guepardsoft.baseapp.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getUserById(String id){
        return userRepository.getUserByIdString(id);
    }


    public void addUser(UserController.UserRequestDTO newUserDTO){
        User newUser = new User();
        Role role = roleRepository.getRoleByIdString(newUserDTO.getRoleId());
       newUser.setRole(role);
        newUser.setUsername(newUserDTO.getUsername());
        newUser.setPassword(newUserDTO.getPassword());
        newUser.setFirstName(newUserDTO.getFirstName());
        newUser.setLastName(newUserDTO.getLastName());
        newUser.setGender(newUserDTO.getGender());
        newUser.setEmail(newUserDTO.getEmail());
        newUser.setPictureURL(newUserDTO.getPictureURL());
        newUser.setStatus(newUserDTO.getStatus());
        userRepository.save(newUser);
        System.out.println("add user: " + newUser);
    }

    public User loginUser(UserController.UserLoginRequestDTO userLoginRequestDTO){
        User user = userRepository.getUserByUsernameAndPassword(userLoginRequestDTO.getUsername(), userLoginRequestDTO.getPassword());
        return user;
    }

    public void updateUser(UserController.UserRequestDTO newUserDTO){
      User updateUser = userRepository.getUserByIdString(newUserDTO.getId());
      Role role = roleRepository.getRoleByIdString(newUserDTO.getRoleId());
      updateUser.setRole(role);
      updateUser.setUsername(newUserDTO.getUsername());
      updateUser.setPassword(newUserDTO.getPassword());
      updateUser.setFirstName(newUserDTO.getFirstName());
      updateUser.setLastName(newUserDTO.getLastName());
      updateUser.setGender(newUserDTO.getGender());
      updateUser.setEmail(newUserDTO.getEmail());
      updateUser.setPictureURL(newUserDTO.getPictureURL());
      updateUser.setStatus(newUserDTO.getStatus());
      userRepository.save(updateUser);
        System.out.println("Update user: " + updateUser);
    }


    public void deleteUser(String id){
        User user = userRepository.getUserByIdString(id);
        userRepository.delete(user);
        System.out.println("Delete user: " + user);
    }

}
