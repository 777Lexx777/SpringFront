package ru.springBoot.lex.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class Login {

    @GetMapping("/login")
    public String getLoginPage() { return "login"; }

    @GetMapping("/logout")
    public String getLogOutPage() { return "login";}

}
