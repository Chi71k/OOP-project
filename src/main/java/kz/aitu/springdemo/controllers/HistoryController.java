package kz.aitu.springdemo.controllers;

import kz.aitu.springdemo.models.Book;
import kz.aitu.springdemo.models.History;
import kz.aitu.springdemo.services.interfaces.HistoryServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("history")
//need to write history in order to use this
public class HistoryController {

    private final HistoryServiceInterface service;

    public HistoryController(HistoryServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<History> getAll(){
        return service.getAll();
    }
    //getting all history as in books

    @GetMapping("/{history_id}")
    public ResponseEntity<History> getByID(@PathVariable("history_id") int id){
        History history = service.getById(id);
        if(history == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404

        return new ResponseEntity<>(history, HttpStatus.OK);
    }
    //getting history records with id as in books

    @PostMapping("/create")
    public ResponseEntity<History> create(@RequestBody History history){
        History createdHistory = service.create(history);
        if(createdHistory == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //creating new history part as in books

    @GetMapping("/book_day/{borrow_day}")
    public List<History> getAllByBorrowDay(@PathVariable("borrow_day") String borrowday){
        return service.getByBorrowday(borrowday);
    }
    //we output all books in history by date when they were borrowed so we can check who may not return books in time
    //if, for example, 10 days have passed we can call to this user and say to return

    @GetMapping("/book_id/{book_id}")
    public List<History> getAllByBookID(@PathVariable("book_id") int bookID){
        return service.getByBookID(bookID);
    }
    //showing in history record with this book_id

    @DeleteMapping("/delete/{book_id}")
    public ResponseEntity<History> deleteHistory(@PathVariable int book_id){
        List<History> history = service.getByBookID(book_id);
        if(history == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        else
            service.deleteByBookID(book_id);
        return null;
    }
    //deleting record from history according to book_id
    @GetMapping("/user_id/{user_id}")
    public List<History> getAllByUserID(@PathVariable("user_id") int userID){
        return service.getByUserID(userID);
    }
    //getting list of books that was borrowed by this user
}
