package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.domain.exception.BookNotFoundException;
import com.bea.springbootmysql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Transactional
    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Book findBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId + " Book Not Found"));
    }

    @Transactional(readOnly = true)
    @Override
    public Book findBook(String bookName) {
        return bookRepository.findByName(bookName)
                .orElseThrow(() -> new BookNotFoundException(bookName + " Book Not Found"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public Book updateBookStock(Long id, int stock) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id + " Book Not Found"));
        book.changeStock(stock);

        bookRepository.save(book);
        return book;
    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
