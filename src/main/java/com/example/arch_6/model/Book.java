package com.example.arch_6.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String author;
    private String genre;
}
