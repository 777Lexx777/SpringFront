package ru.springBoot.lex.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.springBoot.lex.springBoot.model.User;
import ru.springBoot.lex.springBoot.repository.UserRepository;
import ru.springBoot.lex.springBoot.security.SecurityUser;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
   // private final UserDao userDao;
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Autowired
//    public UserDetailsServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService,
    // с единственным методом:
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       User user = userRepository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("user doesn't exists"));
        //return userDao.getUserByName(name); C:\java\SpringBoot\springBoot\src\main\webapp
       return SecurityUser.fromUser(user);

    }
}
