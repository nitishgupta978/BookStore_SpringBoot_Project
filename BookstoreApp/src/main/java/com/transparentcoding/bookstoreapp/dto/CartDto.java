package com.transparentcoding.bookstoreapp.dto;

import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ToString
@Component
public class CartDto {
//    @Pattern(regexp = "^[1-9]{1}[0-9]$",message = "userId InValid")
    public long userId;
//    @Pattern(regexp = "^[1-9]{1}[0-9]$",message = "bookId InValid")
    public long bookId;
    @NotNull(message = "Book Quantity please provide")
    public long quantity;
    @NotNull(message = " please provide total Price of Book ")
    public long totalPrice;
}
