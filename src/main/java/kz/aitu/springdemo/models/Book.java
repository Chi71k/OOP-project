package kz.aitu.springdemo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
//connecting to books table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //generating id automatically
    private int id;
    private String bookname;
    private String author;
    private int year;
    private int price;
    private boolean borrowed;
    @Nullable
    private Integer borrower_id;
    // just as getter and setter but this is our columns in table, our variables
    //Nullable helps to borrower_id to have null value
}