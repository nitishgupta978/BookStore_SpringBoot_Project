package com.transparentcoding.bookstoreapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginDto {
private String emailId;
private String password;
}
