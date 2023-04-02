package com.bea.springbootmysql.repository;

import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.domain.Genres;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends ListCrudRepository<Book, Long> {

    Optional<Book> findByName(String name);

    List<Book> findByGenres(Genres genres);

}
