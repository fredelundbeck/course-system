package edu.dat18c.coursesystem.coursesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.dat18c.coursesystem.coursesystem.repositories.UserRepository;

/**
 * UserController
 */
@Controller
public class UserController 
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/admin/users")
    public String getUsersView(Model model) 
    {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }    
}