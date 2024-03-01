package kz.aitu.springdemo.services.interfaces;

import kz.aitu.springdemo.models.History;

import java.util.List;

public interface HistoryServiceInterface {
    List<History> getAll();
    History getById(int id);
    History deleteById(int id);
    History create(History history);
}
