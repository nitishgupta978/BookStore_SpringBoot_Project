package com.transparentcoding.bookstoreapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "OrderService")
@NoArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    private LocalDate orderDate;
    private long price;
    private long quantity;
    private String address;

    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserRegistration userRegistration;

    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private BookStore bookStore;

    private boolean cancel;

    public OrderDetails(UserRegistration userRegistration, BookStore bookStore, long quantity, long price, String address
                        ) {

        this.orderDate = LocalDate.now();

        this.price = price;
        this.quantity = quantity;
        this.address = address;
        this.userRegistration = userRegistration;
        this.bookStore = bookStore;
        this.cancel = false;
    }
}
