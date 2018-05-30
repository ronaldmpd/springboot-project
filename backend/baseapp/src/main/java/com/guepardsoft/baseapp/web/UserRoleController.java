package com.guepardsoft.baseapp.web;

import com.guepardsoft.baseapp.domain.UserRole;
import com.guepardsoft.baseapp.service.UserRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user_role")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserRole> getAllTeachers(){
        return userRoleService.getAllUserRoles();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUserRole(@RequestBody UserRoleRequestDTO userRoleRequestDTO){
        userRoleService.addNewUserRole(userRoleRequestDTO);
    }

    public static class UserRoleRequestDTO {
        private String userId;
        private String roleId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }
    }
}
