package kz.aitu.springdemo.repositories;

import kz.aitu.springdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
}
//connecting as well as helping to calling functions