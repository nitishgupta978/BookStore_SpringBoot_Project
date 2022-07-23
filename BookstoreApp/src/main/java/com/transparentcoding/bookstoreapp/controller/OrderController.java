package com.transparentcoding.bookstoreapp.controller;


import com.transparentcoding.bookstoreapp.dto.OrderDto;
import com.transparentcoding.bookstoreapp.dto.ResponseDto;
import com.transparentcoding.bookstoreapp.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/OrderDetails")
@RestController
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;


    @PostMapping("/insertOrder")
    public ResponseEntity<ResponseDto> createOrder (@RequestBody OrderDto orderDto){
        OrderDetails orderDetails = orderServiceImp.PlaceOrder(orderDto);
        ResponseDto responseDto=new ResponseDto("Order place Successful ! ",orderDetails);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<ResponseDto> getOrderById( @PathVariable ("orderId")long orderId){
       OrderDetails orderDetails=orderServiceImp.findByOrderId(orderId);
        ResponseDto responseDto= new ResponseDto("Get Call for OrderById Successful !",orderDetails);
        return  new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @PutMapping ("/cancelOrder/{orderId}")
    public ResponseEntity<ResponseDto> cancelOrder(@PathVariable ("orderId") long orderId){
//        OrderDetails orderDetails = orderServiceImp.cancelOrder(orderDto,userId);
        OrderDetails orderDetails=orderServiceImp.cancelOrder(orderId);
        ResponseDto responseDto=new ResponseDto("Get Call for Cancel Order !!!",orderDetails);
        return new ResponseEntity<> (responseDto,HttpStatus.OK);
    }
    @GetMapping("/getOrderAllForUser/{userId}")
    public ResponseEntity<ResponseDto> getOrderForUserById(@PathVariable ("userId") long userId){
       Optional< OrderDetails> orderDetails=orderServiceImp.getAllOrderForUserById(userId);
        ResponseDto responseDto = new ResponseDto("Get Call for OrderForUser Successful !!",orderDetails);
        return new ResponseEntity<> (responseDto,HttpStatus.OK);
    }

}
