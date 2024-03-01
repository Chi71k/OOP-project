package kz.aitu.springdemo.models;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "history")
//connecting to history table
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //generating id automatically
    private int id;
    private int userID;
    private int bookID;
    private String borrowday;
    // just as getter and setter but this is our columns in table, our variables
    // userID and bookID we will take from other tables
}
