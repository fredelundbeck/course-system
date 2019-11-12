package edu.dat18c.coursesystem.coursesystem.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.dat18c.coursesystem.coursesystem.models.Role;

/**
 * RoleRepository
 */
public interface RoleRepository extends CrudRepository<Role, Long>
{

}