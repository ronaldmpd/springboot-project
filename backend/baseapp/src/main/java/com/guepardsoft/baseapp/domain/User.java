package com.guepardsoft.baseapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

  @Id
  private String id;
  @DBRef
  private Role role;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String gender;
  private String email;
  private String pictureURL;
  private Boolean status;

  public User() {
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

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

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public String getPictureURL() {
    return pictureURL;
  }

  public void setPictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
  }

  @Override
  public String toString() {
    return "User{" +
      "id='" + id + '\'' +
      ", role=" + role +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", gender='" + gender + '\'' +
      ", email='" + email + '\'' +
      ", pictureURL='" + pictureURL + '\'' +
      ", status=" + status +
      '}';
  }
}
