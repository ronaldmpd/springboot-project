package com.guepardsoft.baseapp.service;

import com.guepardsoft.baseapp.domain.Role;
import com.guepardsoft.baseapp.domain.User;
import com.guepardsoft.baseapp.domain.UserRole;
import com.guepardsoft.baseapp.repository.RoleRepository;
import com.guepardsoft.baseapp.repository.UserRepository;
import com.guepardsoft.baseapp.repository.UserRoleRepository;
import com.guepardsoft.baseapp.web.UserRoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<UserRole> getAllUserRoles(){
        return  userRoleRepository.findAll();
    }


    public void addNewUserRole(UserRoleController.UserRoleRequestDTO userRoleRequestDTO){
        UserRole newUserRole = new UserRole();
        //User newUser = userRepository.findById(userRoleRequestDTO.getUserId());
        //Role newRole = roleRepository.findOne(userRoleRequestDTO.getRoleId());
        User newUser = userRepository.getUserByIdString(userRoleRequestDTO.getUserId());
        Role newRole = roleRepository.getRoleByIdString(userRoleRequestDTO.getRoleId());
        newUserRole.setUser(newUser);
        newUserRole.setRole(newRole);
        userRoleRepository.save(newUserRole);
    }

}
