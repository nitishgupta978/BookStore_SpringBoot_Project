package com.transparentcoding.bookstoreapp.dto;

import lombok.ToString;

import java.time.LocalDate;

@ToString
public class OrderDto {

    public long orderId;
    public LocalDate orderDate;
    public long price;
    public long quantity;
    public String address;
    public long userId;
    public long bookId;
    public boolean cancel;


}
