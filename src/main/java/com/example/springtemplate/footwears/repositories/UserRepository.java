package com.example.springtemplate.footwears.repositories;

import com.example.springtemplate.footwears.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository
        extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM users",
            nativeQuery = true)
    public List<User> findAllUsers();
    @Query(value = "SELECT * FROM users WHERE id=:u_id",
            nativeQuery = true)
    public User findUserById(@Param("userId") Integer id);
    @Query(value = "REMOVE * FROM users WHERE id=:u_id",
            nativeQuery = true)
    public User deleteById(@Param("userId") Integer id);
}
