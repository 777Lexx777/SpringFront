package ru.springBoot.lex.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.springBoot.lex.springBoot.model.User;
import ru.springBoot.lex.springBoot.service.UserServiceImp;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public AdminController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String index(Model model, Principal principal, User user) {
        String username = principal.getName();
        model.addAttribute("users", userServiceImp.getCountUser());
        model.addAttribute("admin", username);
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String updateUser(@ModelAttribute("user") User user) {

        userServiceImp.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createNewUsers(@ModelAttribute("newUser") User user) {

        userServiceImp.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteUser(@ModelAttribute("user") User user) {
        userServiceImp.deleteUser(user);
        return "redirect:/admin";
    }

}
