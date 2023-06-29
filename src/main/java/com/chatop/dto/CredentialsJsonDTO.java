package com.chatop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CredentialsJsonDTO {

  @JsonProperty(value = "email") 
  private String email;
  
  @JsonProperty(value = "password") 
  private String password;
}
