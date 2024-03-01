package kz.aitu.springdemo.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userID;
    private int bookID;
}
