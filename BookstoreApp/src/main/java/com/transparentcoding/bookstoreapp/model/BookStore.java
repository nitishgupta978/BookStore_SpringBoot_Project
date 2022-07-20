package com.transparentcoding.bookstoreapp.model;

import com.transparentcoding.bookstoreapp.dto.BookStoreDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private String bookLogo;
    private String bookPrice;
    private String bookQuantity;


    public BookStore(BookStoreDto bookStoreDto) {
        this.updateBookStoreById(bookStoreDto);
    }

    public void updateBookStoreById(BookStoreDto bookStoreDto) {
        this.bookName =bookStoreDto. bookName;
        this.bookAuthor =bookStoreDto. bookAuthor;
        this.bookDescription = bookStoreDto.bookDescription;
        this.bookLogo =bookStoreDto. bookLogo;
        this.bookPrice =bookStoreDto. bookPrice;
        this.bookQuantity = bookStoreDto.bookQuantity;
    }
}
