package edu.dat18c.coursesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.dat18c.coursesystem.services.CourseService;

/**
 * AvailableCoursesController
 */
@Controller
public class AvailableCoursesController
{
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/courses")
    public String getAvailableCoursesView(Model model) 
    {
        model.addAttribute("courses", courseService.getAllCourses());
        return "services/availablecourses"; 
    }
}