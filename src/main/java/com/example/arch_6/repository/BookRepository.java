package com.example.arch_6.repository;

import com.example.arch_6.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>, JpaRepository<Book, Long> {
}
