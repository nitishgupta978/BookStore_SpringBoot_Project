package com.transparentcoding.bookstoreapp.dto;

import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ToString
public class BookStoreDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "BookName  is Not valid type like ..Mahabharata")
    public String bookName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "BookAuthor name is Not valid type like ..Guru GopalDas")
    public String bookAuthor;

    @NotEmpty(message = "Book Description not be Empty!!")
    public String bookDescription;

    public String bookLogo;

    @Pattern(regexp = "^[1-9]{1}[0-9\\S]{1,}$" , message = "BookPrice not valid type like..200")
    public String bookPrice;

    @Pattern(regexp = "^[1-9]{1}|[0-9\\S]{1,}$" , message = "BookQuantity not valid type like..200")
    public String bookQuantity;
}
