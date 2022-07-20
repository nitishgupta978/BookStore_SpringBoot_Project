package com.transparentcoding.bookstoreapp.controller;


import com.transparentcoding.bookstoreapp.dto.BookStoreDto;
import com.transparentcoding.bookstoreapp.dto.ResponseDto;
import com.transparentcoding.bookstoreapp.model.BookStore;
import com.transparentcoding.bookstoreapp.service.IBookStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/BookStore")
@Slf4j
public class BookStoreController {
    @Autowired
    private IBookStoreService iBookStoreService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAllBookStore(){
        List<BookStore> bookStoreList=null;
        bookStoreList =iBookStoreService.getBookStoreAll();
        ResponseDto responseDto=new ResponseDto("Get Call Successful",bookStoreList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @GetMapping("/get/{getById}")
    public ResponseEntity<ResponseDto>getBookStoreById(@PathVariable("getById") long bookId){
        BookStore bookStore =null;
        bookStore =iBookStoreService.getBookStoreById(bookId);
        ResponseDto responseDto=new ResponseDto("Get Call for userId Successful!! ",bookStore);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseDto>createUserRegistration(@Valid @RequestBody BookStoreDto bookStoreDto){
        BookStore bookStore= null;
        bookStore = iBookStoreService.createBookStore(bookStoreDto);
        ResponseDto responseDto = new ResponseDto("Create UserRegistration for userId successful !!",bookStore);
        return  new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseDto>updateBookStoreById(@PathVariable("userId")long userId,
                                                                 @RequestBody BookStoreDto bookStoreDto){
        BookStore bookStore=null;
        bookStore=iBookStoreService.updateBookStoreById(userId,bookStoreDto);
        ResponseDto responseDto= new ResponseDto("update userRegistration for userId Successful !!",bookStore);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{deleteById}")
    public ResponseEntity<ResponseDto>deleteBookStoreById(@PathVariable("deleteById")long bookId){
        iBookStoreService.deleteBookStoreById(bookId);
        ResponseDto responseDto=  new ResponseDto("deleteById for userRegistration successful!! ",bookId);
        return  new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
}
