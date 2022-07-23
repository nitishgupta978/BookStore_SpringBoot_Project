package com.transparentcoding.bookstoreapp.service;



import com.transparentcoding.bookstoreapp.dto.OrderDto;
import com.transparentcoding.bookstoreapp.model.OrderDetails;

import java.util.Optional;


public interface IOrderService {

    OrderDetails PlaceOrder(OrderDto orderDto);


   
    Optional<OrderDetails> getAllOrderForUserById(long userId);

 OrderDetails  cancelOrder(long orderId);

   OrderDetails findByOrderId(long orderId);
}
