package com.transparentcoding.bookstoreapp.service;


import com.transparentcoding.bookstoreapp.dto.UserRegistrationDto;
import com.transparentcoding.bookstoreapp.model.UserRegistration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserRegistrationService {

    List<UserRegistration>getUserRegistrationAll();
    UserRegistration getUserRegistrationById(long userId);

    UserRegistration createUserRegistration(UserRegistrationDto userRegistrationDto);

    UserRegistration updateUserRegistrationById( long userId,UserRegistrationDto userRegistrationDto);

    void deleteUserRegistrationById(long userId);
}

//