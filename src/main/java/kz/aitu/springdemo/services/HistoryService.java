package kz.aitu.springdemo.services;

import kz.aitu.springdemo.models.History;
import kz.aitu.springdemo.models.User;
import kz.aitu.springdemo.repositories.HistoryRepositoryInterface;
import kz.aitu.springdemo.services.interfaces.HistoryServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HistoryService implements HistoryServiceInterface {
    private final HistoryRepositoryInterface repo;

    public HistoryService(HistoryRepositoryInterface repo){
        this.repo = repo;
    }

    @Override
    public History create(History history) {
        return repo.save(history);
    }
    @Override
    public List<History> getAll(){
        return repo.findAll();
    }
    @Override
    public History getById(int id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public History deleteById(int id){
        repo.deleteById(id);
        return null;
    }
}
