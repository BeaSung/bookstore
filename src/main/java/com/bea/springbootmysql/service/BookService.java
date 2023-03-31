package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.domain.Genres;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    Book findBook(Long bookId);

    Book findBook(String bookName);

    Book findBook(int stock);

    List<Book> findBooks();

    Book updateBook(Long id, String name, String isbn, Genres genres, int stock);

    void deleteBook(Long id);
}
