package edu.dat18c.coursesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.dat18c.coursesystem.repositories.CourseRepository;

/**
 * CourseController
 */
@Controller
public class CourseController 
{
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value="/admin/courses")
    public String getAdminCourseView(Model model) 
    {
        model.addAttribute("courses", courseRepository.findAll());
        return "admin/courses";
    }

    @GetMapping(value="/admin/test")
    public String getTestView(Model model) 
    {
        model.addAttribute("teachers", courseRepository.findById("WD-2020-F-NODEJS").get().getTeachers());
        return "test";
    }
}