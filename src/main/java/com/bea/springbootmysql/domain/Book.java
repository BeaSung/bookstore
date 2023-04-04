package com.bea.springbootmysql.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// domain class 는 비즈니스 로직이 담기는 클래스 -> 비즈니스 로직은 요구사항에 따라 변경되고 업데이트 될 수 있는 것들
@Getter
@ToString
@NoArgsConstructor
@Table(name="books")
public class Book {

    @Id
    private Long id;
    private String name;
    private String isbn;
    private Genres genres;
    private int price;
    private int stock;

    public Book(String name, String isbn, Genres genres, int price, int stock) {
        this.name = name;
        this.isbn = isbn;
        this.genres = genres;
        this.price = price;
        this.stock = stock;
    }

    public void changeStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException();
        }
        this.stock = stock;
    }
}
