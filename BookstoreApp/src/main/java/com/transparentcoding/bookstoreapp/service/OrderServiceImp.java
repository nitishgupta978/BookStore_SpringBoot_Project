package com.transparentcoding.bookstoreapp.service;


import com.transparentcoding.bookstoreapp.dto.OrderDto;
import com.transparentcoding.bookstoreapp.exception.CartException;
import com.transparentcoding.bookstoreapp.exception.OrderException;
import com.transparentcoding.bookstoreapp.model.BookStore;
import com.transparentcoding.bookstoreapp.model.OrderDetails;
import com.transparentcoding.bookstoreapp.model.UserRegistration;
import com.transparentcoding.bookstoreapp.repository.BookStoreRepository;
import com.transparentcoding.bookstoreapp.repository.OrderRepository;
import com.transparentcoding.bookstoreapp.repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImp implements IOrderService{
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderDetails PlaceOrder(OrderDto orderDto) {

        Optional<UserRegistration> userInsert= userRegistrationRepository.findById(orderDto.userId);
        Optional<BookStore> userBook=bookStoreRepository.findById(orderDto.bookId);
        if (userInsert.isPresent()){
            if (userBook.isPresent()){
                OrderDetails newOrder= new OrderDetails(userInsert.get(),userBook.get(),orderDto.quantity,orderDto.price,orderDto.address);
                return orderRepository.save( newOrder);
            }else {
                throw new CartException("BookId not present");
            }
        }else {
            throw new CartException ( "UserId not present");
        }
    }




    public Optional<OrderDetails> getAllOrderForUserById(long userId) {
        Optional<OrderDetails> orderDetails=orderRepository.findByUserId(userId);
        if(orderDetails.isPresent()){
            return orderDetails;
        }else {
            throw new OrderException("Didn't fine any records ");
        }
    }

    @Override
    public OrderDetails  cancelOrder(long orderId) {
        Optional<OrderDetails> deleteData=orderRepository.findById(orderId);

        if (deleteData.isPresent()){
            deleteData.get().setCancel(true);


            return  orderRepository.save(deleteData.get());
        }else {
            throw  new OrderException("Did not get any order for this order id");
        }

    }

    @Override
    public OrderDetails findByOrderId(long orderId) {
        Optional<OrderDetails> orderList= orderRepository.findById(orderId);
        log.info("All Cart Record find Successful !");
        return orderList.get() ;
    }

}
