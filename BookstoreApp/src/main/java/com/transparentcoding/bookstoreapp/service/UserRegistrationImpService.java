package com.transparentcoding.bookstoreapp.service;
;
import com.transparentcoding.bookstoreapp.dto.UserRegistrationDto;
import com.transparentcoding.bookstoreapp.exception.UserRegistrationException;
import com.transparentcoding.bookstoreapp.model.UserRegistration;
import com.transparentcoding.bookstoreapp.repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UserRegistrationImpService implements IUserRegistrationService {
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Override
    public List<UserRegistration> getUserRegistrationAll() {
        return userRegistrationRepository.findAll();
    }

    @Override
    public UserRegistration getUserRegistrationById(long userId) {
        return userRegistrationRepository.findById(userId).orElseThrow(()->new UserRegistrationException("User Registration userId "+userId+"does not exist!!"));

    }

    @Override
    public UserRegistration createUserRegistration(UserRegistrationDto userRegistrationDto) {
        UserRegistration userRegistration=null;
        userRegistration=new UserRegistration(userRegistrationDto);
        log.debug("User Registration"+userRegistration.toString());
        return userRegistrationRepository.save(userRegistration);
    }

    @Override
    public UserRegistration updateUserRegistrationById(long userId, UserRegistrationDto userRegistrationDto) {
        UserRegistration userRegistration=this.getUserRegistrationById(userId);
        userRegistration.updateUserRegistrationById(userRegistrationDto);
        return userRegistrationRepository.save(userRegistration);
    }

    @Override
    public void deleteUserRegistrationById(long userId) {

        UserRegistration userRegistration=this.getUserRegistrationById(userId);
        userRegistrationRepository.delete(userRegistration);
    }
}
