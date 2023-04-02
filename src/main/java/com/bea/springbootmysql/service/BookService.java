package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    Book findBook(Long bookId);

    Book findBook(String bookName);

    List<Book> findBooks();

    Book updateBookStock(Long id, int stock);

    void deleteBook(Long id);
}
