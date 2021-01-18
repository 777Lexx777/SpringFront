package ru.springBoot.lex.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.springBoot.lex.springBoot.service.UserServiceImp;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String printUsersId(Model model, Principal principal) {

        String username = principal.getName();

        model.addAttribute("user", username);
        System.out.println("user id" + username);
        model.addAttribute("userInfo", userServiceImp.getUserByName(username));
        return "userInfo";
    }
}
