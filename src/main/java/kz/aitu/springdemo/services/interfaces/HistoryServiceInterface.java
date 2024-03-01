package kz.aitu.springdemo.services.interfaces;

import kz.aitu.springdemo.models.History;

import java.util.List;

public interface HistoryServiceInterface {
    List<History> getAll();
    History getById(int id);
    History create(History history);
    List<History> getByBorrowday(String borrowday);
    List<History> getByBookID(int bookID);
    History deleteByBookID(int bookID);
    List<History> getByUserID(int userID);
}
//calling all history functions so we can override them and use in future, also we mention their inputs