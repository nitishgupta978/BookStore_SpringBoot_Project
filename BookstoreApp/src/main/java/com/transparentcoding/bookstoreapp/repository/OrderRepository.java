package com.transparentcoding.bookstoreapp.repository;


import com.transparentcoding.bookstoreapp.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Long> {
    @Query(value = "select * from order_service where user_id =:userId", nativeQuery = true)
    Optional<OrderDetails> findByUserId(Long userId);
}
