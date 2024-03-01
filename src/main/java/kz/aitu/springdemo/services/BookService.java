package kz.aitu.springdemo.services;

import kz.aitu.springdemo.models.Book;
import kz.aitu.springdemo.models.History;
import kz.aitu.springdemo.models.User;
import kz.aitu.springdemo.repositories.BookRepositoryInterface;
import kz.aitu.springdemo.repositories.HistoryRepositoryInterface;
import kz.aitu.springdemo.repositories.UserRepositoryInterface;
import kz.aitu.springdemo.services.interfaces.BookServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service

public class BookService implements BookServiceInterface{
    @Autowired
    private BookRepositoryInterface bookRepository;
    @Autowired
    private UserRepositoryInterface userRepository;
    @Autowired
    private HistoryRepositoryInterface historyRepository;
    // connect other repositories to take data from them


    private final BookRepositoryInterface repo;

    public BookService(BookRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> getAll() {
        return repo.findAll();
    }
    //get all books in DB

    @Override
    public Book getById(int id) {
        return repo.findById(id).orElse(null);
    }
    //get books by id

    @Override
    public Book create(Book book) {
        return repo.save(book);
    }
    //creating books and adding them to table

    @Override
    public Book deleteById(int id) {
        repo.deleteById(id);
        return null;
    }
    //delete any book by its id

    @Override
    public Book borowBook(int book_id, int user_id, String borrowday) {
        Book book = getById(book_id);
        User user = userRepository.findById(user_id).orElse(null);
        History history = new History();

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrower_id(user_id);
            book.setBorrowed(true);
            book = create(book);
            history.setUserID(user_id);
            history.setBookID(book_id);
            history.setBorrowday(borrowday);
            historyRepository.save(history);
            return book;
        }
        return null;
    }
    //by borrowing book we save data in other table with name "history" and also save date when book borrowed
    //also it checks if book already borrowed or is book or user exists
    //also we add borrower id(user id) to table of books and make borrowed = true, so we cannot borrow it again

    @Override
    public Book returnBook(int book_id) {
        Book book = getById(book_id);
        if (book != null && book.isBorrowed()) {
            book.setBorrower_id(null);
            book.setBorrowed(false);
            return create(book);
        }
        return null;
    }

}
//actually here we just overriding (calling) functions that we described in other files