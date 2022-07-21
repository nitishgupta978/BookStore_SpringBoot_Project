package com.transparentcoding.bookstoreapp.controller;

import com.transparentcoding.bookstoreapp.dto.CartDto;
import com.transparentcoding.bookstoreapp.dto.ResponseDto;
import com.transparentcoding.bookstoreapp.model.Cart;
import com.transparentcoding.bookstoreapp.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> insertItem(@Valid @RequestBody CartDto cartDto) {
        Cart cart= null;
        cart = iCartService.insertItems(cartDto);
        ResponseDto responseDto = new ResponseDto("Cart inserted  successfully !", cart);
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAllCartDetails(){
        List<Cart>cartList=iCartService.getCartDetails();
        ResponseDto responseDto= new ResponseDto("Get Call Successful",cartList);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getCartById/{cartId}")
    public ResponseEntity<ResponseDto>getCardDetailsById(@PathVariable("cartId")long cardId){
        Cart cartList =  iCartService.getCartDetailsById(cardId);
        ResponseDto responseDto=new ResponseDto("Get call Successful !",cartList);
        return  new ResponseEntity<>(responseDto,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<ResponseDto> deleteCartById(@PathVariable("Id") long cartId) {
        iCartService.deleteCartItemById(cartId);
        ResponseDto responseDto = new ResponseDto("Cart deleteById successfully",cartId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/updateById/{cartId}")
    public ResponseEntity<ResponseDto> updateCartById(long cartId,@Valid @RequestBody CartDto cartDto) {
        Cart updateRecord = iCartService.updateRecordById(cartId,cartDto);
        ResponseDto responseDto = new ResponseDto(" Cart Record updated successfully by Id",updateRecord);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.ACCEPTED);
    }
    @PutMapping("/UpdateQuantityPrice/{Id}")
    public ResponseEntity<ResponseDto> updateQuantityDataPrice(@RequestParam long cartId, @RequestParam long quantity, @RequestParam long totalPrice) {
        Cart updateQuantityPrice = iCartService.updateQuantityPrice(cartId, quantity, totalPrice);
        ResponseDto dto = new ResponseDto("Cart quantity update Successfully " ,updateQuantityPrice);
        return  new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }
}
