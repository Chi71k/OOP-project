package kz.aitu.springdemo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.IntegerList;
import org.antlr.v4.runtime.misc.IntegerStack;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_db")
//connecting to table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //generating id automatically
    private int id;
    private String username;
    private String phone;
    private String email;
    // just as getter and setter but this is our columns in table, our variables
}