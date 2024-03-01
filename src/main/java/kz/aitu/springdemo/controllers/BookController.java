package kz.aitu.springdemo.controllers;

import jakarta.persistence.GeneratedValue;
import kz.aitu.springdemo.models.Book;
import kz.aitu.springdemo.models.History;
import kz.aitu.springdemo.services.interfaces.BookServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
//mapping is what we must write in url in order to use this controllers
public class BookController {

    private final BookServiceInterface service;

    public BookController(BookServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Book> getAll(){
        return service.getAll();
    }
    //we can get list of all books in table but in order to it we need to write /all

    @GetMapping("/{book_id}")
    public ResponseEntity<Book> getById(@PathVariable("book_id") int id){
        Book book = service.getById(id);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404

        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    //getting all books by its id, just need to write id of book
    //it also checks is there are such book with suсh id

    @PostMapping("/create")
    public ResponseEntity<Book> create(@RequestBody Book book){
        Book createdBook = service.create(book);
        if(createdBook == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //creating books with writing data in body in postmen and using post mapping to add data
    //also it checks is created book empty or not

    @DeleteMapping("/delete/{book_id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int book_id){
        Book book = service.getById(book_id);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        else
            service.deleteById(book_id);
        return null;
    }
    //deleting book by its id also has conditions and responses to them

    @PostMapping("/borrow/book_id/{book_id}/user_id/{user_id}")
    public ResponseEntity<Book> borrowBook(@PathVariable int book_id, @PathVariable int user_id, @RequestBody String borrowday){
        Book borrowedBook = service.borowBook(book_id, user_id, borrowday);
        if (borrowedBook != null){
            return new ResponseEntity<>(borrowedBook, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //borrowing book using userID and bookID also we write Date in body as we were creating new book
    //also checks if borrowing book already borrowed or not

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