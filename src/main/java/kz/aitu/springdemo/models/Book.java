package kz.aitu.springdemo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookname;
    private String author;
    private int year;
    private int price;
    private boolean borrowed;
    @Nullable
    private Integer borrower_id;

}