package com.pawsitivity.server.controller;

import com.pawsitivity.server.dto.RegistrationDto;
import com.pawsitivity.server.dto.UserDto;
import com.pawsitivity.server.exception.UserAlreadyExistsException;
import com.pawsitivity.server.model.User;
import com.pawsitivity.server.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationDto", new RegistrationDto());
        return "register";
    }

    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute("registrationDto") RegistrationDto registrationDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "register";
        }
        try {
            userService.save(registrationDto);
        } catch (UserAlreadyExistsException e) {
            bindingResult.rejectValue("username", "user.exists", "Username already in use");
            model.addAttribute("registrationDto", registrationDto);
            return "register";
        }
        return "redirect:/register?success";
    }
}