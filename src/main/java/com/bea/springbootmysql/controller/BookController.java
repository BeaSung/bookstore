package com.bea.springbootmysql.controller;

import com.bea.springbootmysql.controller.request.AddBookRequest;
import com.bea.springbootmysql.controller.request.UpdateBookStockRequest;
import com.bea.springbootmysql.controller.response.BookResponse;
import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/books")
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getAll() {
        return bookService.findBooks()
                .stream()
                .map(book -> new BookResponse(book))
                .toList();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        return new BookResponse(book);
    }

    @GetMapping
    public BookResponse getBook(@RequestParam String name) {
        Book book = bookService.findBook(name);
        return new BookResponse(book);
    }

    @PostMapping
    public void addBook(@RequestBody AddBookRequest request) {
        Book book = request.convertToBook();
        bookService.addBook(book);
    }

    @PatchMapping("/{id}")
    public BookResponse updateBookStock(@PathVariable Long id, @RequestBody UpdateBookStockRequest request) {
        Book book = bookService.updateBookStock(id, request.getStock());
        return new BookResponse(book);
    }
}
