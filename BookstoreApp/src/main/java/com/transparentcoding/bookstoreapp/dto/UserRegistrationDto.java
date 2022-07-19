package com.transparentcoding.bookstoreapp.dto;

import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ToString
public class UserRegistrationDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee  firstName is Not valid")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee  firstName is Not valid")
    public String lastName;

    @NotNull(message = "DOB not Null please fill the date of birth")
    public String dOB;

    @Pattern(regexp = " (?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" ,message="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
    public String password;

    @Pattern( regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$\n"
             ,message="email not valid!! please check eg. username@domain.com ")
    public String emailId;
}
