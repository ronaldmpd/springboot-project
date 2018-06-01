package com.guepardsoft.baseapp.web;

import com.guepardsoft.baseapp.domain.User;
import com.guepardsoft.baseapp.service.UserService;
import com.guepardsoft.baseapp.util.ResponseREST;
import com.guepardsoft.baseapp.util.StringUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllTeachers(){
        return userService.getAllUsers();
    }

    @RequestMapping(path="/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody UserRequestDTO newTeacherDTO){
        userService.addUser(newTeacherDTO);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseREST loginUser(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        ResponseREST responseREST = new ResponseREST();

        System.out.println("userLoginRequestDTO : " + userLoginRequestDTO);

        if(StringUtil.isNullOrEmpty(userLoginRequestDTO.getUsername())){
            responseREST.setMessage("required username");
            return responseREST;
        }

        if(StringUtil.isNullOrEmpty(userLoginRequestDTO.getPassword())){
            responseREST.setMessage("required password");
            return responseREST;
        }

        User userLogin = userService.loginUser(userLoginRequestDTO);
        if(userLogin == null)
        {
            responseREST.setMessage("Username and password, incorrect");
        }else {
            responseREST.setSuccess(true);
            responseREST.setMessage("OK");
            responseREST.setResults(userLogin);
        }
        System.out.println("User login : " + responseREST);
        return  responseREST;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void updateUser(@RequestBody User newUser)
    {
      System.out.println("Update user: " + newUser);
      userService.updateUser(newUser);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

        public static class UserRequestDTO{
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String gender;
        private String email;
        private String pictureURL;
        private Boolean status;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

            public String getPictureURL() {
                return pictureURL;
            }

            public void setPictureURL(String pictureURL) {
                this.pictureURL = pictureURL;
            }

            public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }
    }

    public static class UserLoginRequestDTO {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "UserLoginRequestDTO{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
