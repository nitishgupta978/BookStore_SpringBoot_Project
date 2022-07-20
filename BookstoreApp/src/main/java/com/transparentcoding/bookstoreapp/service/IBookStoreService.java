package com.transparentcoding.bookstoreapp.service;

import com.transparentcoding.bookstoreapp.dto.BookStoreDto;
import com.transparentcoding.bookstoreapp.model.BookStore;

import java.util.List;

public interface IBookStoreService {
    List<BookStore> getBookStoreAll();
    BookStore getBookStoreById(long bookId);

    BookStore createBookStore(BookStoreDto bookStoreDto);

    BookStore updateBookStoreById( long bookId,BookStoreDto bookStoreDto);

    void deleteBookStoreById(long bookId);


}
