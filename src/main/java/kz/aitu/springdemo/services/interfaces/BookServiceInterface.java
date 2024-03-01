package kz.aitu.springdemo.services.interfaces;

import kz.aitu.springdemo.models.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getAll();
    Book getById(int id);
    Book create(Book book);
    Book deleteById(int id);
    Book borowBook(int book_id, int user_id, String borrowday);
    Book returnBook(int book_id);
}
//calling all book functions so we can override them and use in future, also we mention their inputs