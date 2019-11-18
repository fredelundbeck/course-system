package edu.dat18c.coursesystem.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import edu.dat18c.coursesystem.models.User;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, Long> 
{
    public boolean existsByEmail(String email);
    public Optional<User> findByEmail(String email);
}