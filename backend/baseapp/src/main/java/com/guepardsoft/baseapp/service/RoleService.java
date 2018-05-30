package com.guepardsoft.baseapp.service;

import com.guepardsoft.baseapp.domain.Role;
import com.guepardsoft.baseapp.repository.RoleRepository;
import com.guepardsoft.baseapp.web.RoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        List<Role> users = roleRepository.findAll();
        return users;
    }

    public Role getRoleById(String id){
        return roleRepository.getRoleByIdString(id);
    }

    public void addRole(RoleController.RoleRequestDTO newUserDTO){
        Role newUser = new Role();
        newUser.setName(newUserDTO.getName());
        newUser.setDescription(newUserDTO.getDescription());
        newUser.setStatus(newUserDTO.getStatus());
        roleRepository.save(newUser);
        System.out.println("the Name of role is --->" + newUser.getName());
    }


    public void updateRole(Role role){
        roleRepository.save(role);
        System.out.println("Update role: " + role);
    }


    public void deleteRole(String id){
        Role role = roleRepository.getRoleByIdString(id);
        roleRepository.delete(role);
        System.out.println("Delete role: " + role);
    }

}
