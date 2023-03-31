package com.bea.springbootmysql.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="book")
public class Book {

    @Id
    private Long id;
    private String name;
    private String isbn;
    private Genres genres;
    private int stock;
}
