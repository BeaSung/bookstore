package com.bea.springbootmysql.controller.response;

import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.domain.Genres;
import lombok.Data;

@Data
public class BookResponse {

    private final Long id;
    private final String name;
    private final String isbn;
    private final Genres genres;
    private final int stock;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.isbn = book.getIsbn();
        this.genres = book.getGenres();
        this.stock = book.getStock();
    }
}
