package com.transparentcoding.bookstoreapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cartDetails")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private long cartId;
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserRegistration userRegistration;

    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private BookStore bookStore;


    private long quantity;
    private long totalPrice;

    public Cart(UserRegistration  userRegistration,BookStore bookStore,long quantity,long totalPrice) {

        this.userRegistration =userRegistration;
        this.bookStore = bookStore;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }


    public Cart(long cartId, long quantity, BookStore bookStore, UserRegistration userRegistration, long totalPrice) {
    }
}
