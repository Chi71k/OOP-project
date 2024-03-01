package kz.aitu.springdemo.repositories;

import kz.aitu.springdemo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositoryInterface extends JpaRepository<Book, Integer>{
}
//connecting as well as helping to calling functions