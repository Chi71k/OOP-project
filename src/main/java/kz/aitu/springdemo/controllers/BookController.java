package kz.aitu.springdemo.controllers;

import kz.aitu.springdemo.models.Book;
import kz.aitu.springdemo.services.interfaces.BookServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookServiceInterface service;

    public BookController(BookServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Book> getAll(){
        return service.getAll();
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<Book> getById(@PathVariable("book_id") int id){
        Book book = service.getById(id);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> create(@RequestBody Book book){
        Book createdBook = service.create(book);
        if(createdBook == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{book_id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id){
        Book book = service.getById(id);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        else
            service.deleteById(id);
        return null;
    }

    @PostMapping("/borrow/{book_id}/{user_id}")
    public ResponseEntity<Book> borrowBook(@PathVariable int book_id, @PathVariable int user_id){
        Book borrowedBook = service.borowBook(book_id, user_id);
        if (borrowedBook != null){
            return new ResponseEntity<>(borrowedBook, HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/return/{book_id}")
    public ResponseEntity<Book> returnBook(@PathVariable int book_id){
        Book returnedBook = service.returnBook(book_id);
        if (returnedBook != null){
            return new ResponseEntity<>(returnedBook, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}