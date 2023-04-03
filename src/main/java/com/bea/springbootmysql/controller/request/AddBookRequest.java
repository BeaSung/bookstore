package com.bea.springbootmysql.controller.request;

import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.domain.Genres;
import lombok.Data;

@Data
public class AddBookRequest {
    private String name;
    private String isbn;
    private Genres genres;
    private int price;
    private int stock;

    public Book convertToBook() {
        return new Book(name, isbn, genres, price, stock);
    }
}
