package com.transparentcoding.bookstoreapp.repository;

import com.transparentcoding.bookstoreapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query(value = "select * from cart where book_id =:bookId", nativeQuery = true)
    Optional<Cart> findByBookId(Integer bookId);

}
