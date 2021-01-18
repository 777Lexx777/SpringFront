package ru.springBoot.lex.springBoot.service;

import ru.springBoot.lex.springBoot.model.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);

    List<User> getCountUser();//String count



    User getUserId(long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

}
