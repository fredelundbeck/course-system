package edu.dat18c.coursesystem.coursesystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.dat18c.coursesystem.coursesystem.models.Course;

/**
 * CourseRepository
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> 
{

    
}