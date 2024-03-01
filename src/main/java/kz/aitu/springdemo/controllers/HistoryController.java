package kz.aitu.springdemo.controllers;

import kz.aitu.springdemo.models.History;
import kz.aitu.springdemo.services.interfaces.HistoryServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("history")
public class HistoryController {

    private final HistoryServiceInterface service;

    public HistoryController(HistoryServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<History> getAll(){
        return service.getAll();
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<History> getByID(@PathVariable("history_id") int id){
        History history = service.getById(id);
        if(history == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404

        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<History> create(@RequestBody History history){
        History createdHistory = service.create(history);
        if(createdHistory == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{book_id}")
    public ResponseEntity<History> deleteHistory(@PathVariable int id){
        History history = service.getById(id);
        if(history == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        else
            service.deleteById(id);
        return null;
    }
}
