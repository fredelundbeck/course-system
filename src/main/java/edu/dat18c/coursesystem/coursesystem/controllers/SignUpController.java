package edu.dat18c.coursesystem.coursesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.dat18c.coursesystem.coursesystem.models.User;

/**
 * SignUpController
 */
@Controller
public class SignUpController 
{
    @GetMapping(value = "/signup")
    public String getSignUpPage()
    {
        return "signup/signup";
    }

    @PostMapping(value = "/signup")
    public String signUp(@ModelAttribute User user)
    {
        return "redirect:/";
    }
}