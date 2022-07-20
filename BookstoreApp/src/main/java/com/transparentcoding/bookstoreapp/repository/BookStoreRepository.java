package com.transparentcoding.bookstoreapp.repository;

import com.transparentcoding.bookstoreapp.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore,Long> {

}
