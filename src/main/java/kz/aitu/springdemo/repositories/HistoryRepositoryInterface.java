package kz.aitu.springdemo.repositories;

import kz.aitu.springdemo.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepositoryInterface extends JpaRepository<History, Integer> {
}
