package com.guepardsoft.baseapp.web;

import com.guepardsoft.baseapp.domain.Role;
import com.guepardsoft.baseapp.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")

public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @RequestMapping(path="/{id}",method = RequestMethod.GET)
    public Role getRoleById(@PathVariable String id){
        return roleService.getRoleById(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addRole(@RequestBody RoleRequestDTO newRoleDTO){
        roleService.addRole(newRoleDTO);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void updateRole(@RequestBody Role newRole){
        roleService.updateRole(newRole);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        roleService.deleteRole(id);
    }


    public static class RoleRequestDTO{
        private String name;
        private String description;
        private Boolean status;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }
    }

}
