package com.transparentcoding.bookstoreapp.service;


import com.transparentcoding.bookstoreapp.dto.CartDto;
import com.transparentcoding.bookstoreapp.model.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    Cart insertItems(CartDto cartDto);
    List<Cart> getCartDetails();
    Cart getCartDetailsById(long cartId);
    Optional<Cart> deleteCartItemById(long cartId);
    Cart updateRecordById(long cartId, CartDto cartDto);

    Cart updateQuantityPrice(long cartId, long quantity, long totalPrice);

}
