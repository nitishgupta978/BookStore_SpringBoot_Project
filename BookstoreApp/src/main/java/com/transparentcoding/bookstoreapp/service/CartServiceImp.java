package com.transparentcoding.bookstoreapp.service;


import com.transparentcoding.bookstoreapp.dto.CartDto;
import com.transparentcoding.bookstoreapp.exception.BookStoreException;
import com.transparentcoding.bookstoreapp.exception.CartException;
import com.transparentcoding.bookstoreapp.model.BookStore;
import com.transparentcoding.bookstoreapp.model.Cart;
import com.transparentcoding.bookstoreapp.model.UserRegistration;
import com.transparentcoding.bookstoreapp.repository.BookStoreRepository;
import com.transparentcoding.bookstoreapp.repository.CartRepository;
import com.transparentcoding.bookstoreapp.repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CartServiceImp implements ICartService{
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart insertItems(CartDto cartDto) {
        Optional<UserRegistration> userInsert= userRegistrationRepository.findById(cartDto.userId);
        Optional<BookStore> userBook=bookStoreRepository.findById(cartDto.bookId);
        if (userInsert.isPresent()){
            if (userBook.isPresent()){
                Cart newCart= new Cart(userInsert.get(),userBook.get(),cartDto.quantity,cartDto.totalPrice);
                return cartRepository.save(newCart);
            }else {
                throw new CartException("BookId not present");
            }
        }else {
            throw new CartException ( "UserId not present");
        }
    }

    @Override
    public List<Cart> getCartDetails() {
        List<Cart>cartList= cartRepository.findAll();
       log.info("All Cart Record find Successful !");
        return cartList;
    }

    @Override
    public Cart getCartDetailsById(long cartId) {
        Optional<Cart>optionalCart=cartRepository.findById(cartId);
        if (optionalCart.isPresent()){
            return optionalCart.get();

        }else {
            throw new BookStoreException("didn't find any record regarding this cardId");
        }
    }

    @Override
    public Optional<Cart> deleteCartItemById(long cartId) {
        Optional<Cart>delete=cartRepository.findById(cartId);
        if (delete.isPresent()){
            cartRepository.deleteById(cartId);
            return delete;
        }else {
            throw new BookStoreException("Didn't match this id");
        }

    }

    @Override
    public Cart updateRecordById(long cartId, CartDto cartDto) {
        Optional<Cart>cart=cartRepository.findById(cartId);
        Optional<BookStore>bookStore=bookStoreRepository.findById(cartDto.bookId);
        Optional<UserRegistration>userRegistration=userRegistrationRepository.findById(cartDto.userId);

        if (cart.isPresent()){
           if( bookStore.isPresent() && userRegistration.isPresent()){
               Cart cartData = new Cart(cartId,cartDto.quantity,bookStore.get(),userRegistration.get(),cartDto.totalPrice);


           }else{
               throw new CartException("Book or User Doesn't Exist!!!");
           }
        }else{
            throw  new CartException("Invalid CartId !!!");
        }
        return null;
    }

    @Override
    public Cart updateQuantityPrice(long cartId, long quantity, long totalPrice) {
        System.out.println(cartId+" "+ quantity+" "+ totalPrice);
        Optional<Cart>cart=cartRepository.findById(cartId);
        System.out.println(cart.get());

        if (cart.isPresent()){
            cart.get().setQuantity(quantity);
            cart.get().setTotalPrice(totalPrice);
            cartRepository.save(cart.get());
        }else {
            throw  new CartException("Invalid Id");
        }
        return cart.get();
    }

}
