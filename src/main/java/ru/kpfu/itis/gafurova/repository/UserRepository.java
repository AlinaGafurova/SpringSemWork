package ru.kpfu.itis.gafurova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.zaripov.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);
}
