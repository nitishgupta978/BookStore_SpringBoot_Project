package com.transparentcoding.bookstoreapp.service;

;
import com.transparentcoding.bookstoreapp.dto.BookStoreDto;
import com.transparentcoding.bookstoreapp.exception.BookStoreException;
import com.transparentcoding.bookstoreapp.model.BookStore;
import com.transparentcoding.bookstoreapp.repository.BookStoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookStoreServiceImp implements IBookStoreService {
    @Autowired
    private BookStoreRepository bookStoreRepository;
    @Override
    public List<BookStore> getBookStoreAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStore getBookStoreById(long bookId) {
        return bookStoreRepository.findById(bookId).orElseThrow(()->new BookStoreException("BookStore this  bookId "+bookId+"does not exist!!"));
    }

    @Override
    public BookStore createBookStore(BookStoreDto bookStoreDto) {
        BookStore bookStore=null;
        bookStore=new BookStore(bookStoreDto);
        log.debug("User Registration"+bookStore.toString());
        return bookStoreRepository.save(bookStore);

    }

    @Override
    public BookStore updateBookStoreById(long bookId, BookStoreDto bookStoreDto) {
        BookStore bookStore=this.getBookStoreById(bookId);
       bookStore.updateBookStoreById(bookStoreDto);
        return bookStoreRepository.save(bookStore);
    }

    @Override
    public void deleteBookStoreById(long bookId) {

       BookStore bookStore=this.getBookStoreById(bookId);
        bookStoreRepository.delete(bookStore);
    }
}
