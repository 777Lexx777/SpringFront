package ru.springBoot.lex.springBoot.dao;

import ru.springBoot.lex.springBoot.model.User;

import java.util.List;


public interface UserDao {

    User getUserByName(String name);

    List<User> getCountUser();//String count

    User getUserId(long id);

    void saveUser(User user);

    void updateUser(User user);//long id,

    void deleteUser(User user);


}
