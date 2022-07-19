package com.transparentcoding.bookstoreapp.controller;

import com.transparentcoding.bookstoreapp.dto.ResponseDto;
import com.transparentcoding.bookstoreapp.dto.UserRegistrationDto;
import com.transparentcoding.bookstoreapp.model.UserRegistration;
import com.transparentcoding.bookstoreapp.service.IUserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userRegistration")
@Slf4j
public class UserRegistrationController {
    @Autowired
    private IUserRegistrationService userRegistrationService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto>getAllUserRegistration(){
        List<UserRegistration>userRegistrationList=null;
        userRegistrationList =userRegistrationService.getUserRegistrationAll();
        ResponseDto responseDto=new ResponseDto("Get Call Successful",userRegistrationList);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/get/{getById}")
    public ResponseEntity<ResponseDto>getUserRegistrationById(@PathVariable("getById") long userId){
         UserRegistration userRegistration =null;
        userRegistration =userRegistrationService.getUserRegistrationById(userId);
        ResponseDto responseDto=new ResponseDto("Get Call for userId Successful!! ",userRegistration);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseDto>createUserRegistration(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        UserRegistration userRegistration= null;
         userRegistration = userRegistrationService.createUserRegistration(userRegistrationDto);
         ResponseDto responseDto = new ResponseDto("Create UserRegistration for userId successful !!",userRegistration);
         return  new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseDto>updateUserRegistrationById(@PathVariable("userId")long userId,
                                                                 @RequestBody UserRegistrationDto userRegistrationDto){
        UserRegistration  userRegistration=null;
        userRegistration=userRegistrationService.updateUserRegistrationById(userId,userRegistrationDto);
        ResponseDto responseDto= new ResponseDto("update userRegistration for userId Successful !!",userRegistration);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{deleteById}")
    public ResponseEntity<ResponseDto>deleteUserRegistrationById(@PathVariable("deleteById")long userId){
        userRegistrationService.deleteUserRegistrationById(userId);
        ResponseDto responseDto=  new ResponseDto("deleteById for userRegistration successful!! ",userId);
        return  new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

}
