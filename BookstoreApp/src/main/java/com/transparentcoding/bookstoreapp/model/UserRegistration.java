package com.transparentcoding.bookstoreapp.model;

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

    public UserRegistration(String firstName, String lastName, String dOB,
                            String password, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dOB = dOB;
        this.password = password;
        this.emailId = emailId;
    }
////    when we Implement IUserRegistrationService in UserRegistrationImplService then when we create method by updateUserRegistrationById then we write this
//    public UserRegistration(UserRegistrationDto userRegistrationDto) {
//        this.updateUserRegistrationById(userRegistrationDto);
//
//    }
//
//    public void updateUserRegistrationById(UserRegistrationDto userRegistrationDto) {
//        this.firstName = userRegistrationDto.firstName;
//        this.lastName = userRegistrationDto.lastName;
//        this.dOB = userRegistrationDto.dOB;
//        this.password =userRegistrationDto.password;
//        this.emailId = userRegistrationDto.emailId;
//    }
}
