package com.chatop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsersJsonDTO {

  @JsonProperty(value = "email") 
  private String email;
  
  @JsonProperty(value = "name") 
  private String name;
  
  @JsonProperty(value = "password") 
  private String password;
}
