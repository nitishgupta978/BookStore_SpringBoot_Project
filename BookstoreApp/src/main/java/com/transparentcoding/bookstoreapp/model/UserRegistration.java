package com.transparentcoding.bookstoreapp.model;

import com.transparentcoding.bookstoreapp.dto.UserRegistrationDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;
    private String firstName;
    private String lastName;
    private String dOB;
    private String password;
    private String emailId;


    
////    when we Implement IUserRegistrationService in UserRegistrationImplService then when we create method by updateUserRegistrationById then we write this
//    public UserRegistration(UserRegistrationDto userRegistrationDto) {
//        this.updateUserRegistrationById(userRegistrationDto);
//
//    }
//
    public UserRegistration(UserRegistrationDto userRegistrationDto) {
        this.firstName = userRegistrationDto.firstName;
        this.lastName = userRegistrationDto.lastName;
        this.dOB = userRegistrationDto.dOB;
        this.password =userRegistrationDto.password;
        this.emailId = userRegistrationDto.emailId;
    }
}
