package edu.dat18c.coursesystem.coursesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AboutController
 */
@Controller
public class AboutController 
{
    @GetMapping(value = "/about")
    public String getAboutPage() 
    {
        return "about/about";
    }
}