package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.domain.Genres;
import com.bea.springbootmysql.domain.exception.BookNotFoundException;
import com.bea.springbootmysql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId + " Book Not Found"));
    }

    @Override
    public Book findBook(String bookName) {
        return bookRepository.findByName(bookName)
                .orElseThrow(() -> new BookNotFoundException(bookName + " Book Not Found"));
    }

    @Override
    public Book findBook(int stock) {
        return null;
    }

    @Override
    public List<Book> findBooks() {
        return null;
    }

    @Override
    public Book updateBook(Long id, String name, String isbn, Genres genres, int stock) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
