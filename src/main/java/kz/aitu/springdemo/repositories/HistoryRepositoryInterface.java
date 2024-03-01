package kz.aitu.springdemo.repositories;

import kz.aitu.springdemo.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepositoryInterface extends JpaRepository<History, Integer> {
    List<History> findByBorrowday(String borrowday);
    List<History> getByBookID(int bookID);
    List<History> deleteByBookID(int bookID);
    List<History> getByUserID(int userID);
}
//connecting as well as helping to calling functions
//here for example we added new function which dont exist in list of basic ones