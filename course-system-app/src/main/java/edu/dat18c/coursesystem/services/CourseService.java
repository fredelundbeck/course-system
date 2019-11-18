package edu.dat18c.coursesystem.coursesystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dat18c.coursesystem.coursesystem.models.Course;
import edu.dat18c.coursesystem.coursesystem.repositories.CourseRepository;

/**
 * CourseService
 */
@Service
public class CourseService 
{
    @Autowired
    private CourseRepository courseRepository;
    
    public Iterable<Course> findAllUsers()
    {
        return courseRepository.findAll();
    }

    public Optional<Course> findByCourseCode(String courseCode)
    {
        return courseRepository.findById(courseCode);
    }
}