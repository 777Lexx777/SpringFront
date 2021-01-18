 package ru.springBoot.lex.springBoot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.springBoot.lex.springBoot.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByName(String name);

}
//Ripository