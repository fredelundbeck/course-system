package edu.dat18c.coursesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.dat18c.coursesystem.models.User;
import edu.dat18c.coursesystem.repositories.UserRepository;

/**
 * UserController
 */
@Controller
public class UserController 
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/admin/users/create")
    public String getCreateUserView() 
    {
        return "admin/user/user_create";
    }
    
    @PostMapping(value="/admin/users/create")
    public String saveUser(@ModelAttribute User user) 
    {
        userRepository.save(user);
        return "redirect:/admin/users";
    }
    
    @GetMapping(value="/admin/users")
    public String getAllUsersView(Model model) 
    {
        model.addAttribute("users", userRepository.findAll());
        return "admin/user/users";
    }

    @GetMapping(value="/admin/users/edit/{id}")
    public String getEditUserView(@PathVariable long id, Model model) 
    {
        model.addAttribute("user", userRepository.findById(id));
        return "admin/user/user_edit";
    }
    
    @PostMapping(value="/admin/users/delete/{id}")
    public String postMethodName(@PathVariable long id) 
    {
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }
    
}