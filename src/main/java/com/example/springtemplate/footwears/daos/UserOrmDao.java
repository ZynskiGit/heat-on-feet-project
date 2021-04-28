package com.example.springtemplate.footwears.daos;

import com.example.springtemplate.footwears.models.User;
import com.example.springtemplate.footwears.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserOrmDao {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/orm/create/user/{fn}/{ln}/{un}/{pw}/{em}/{db}")
    public User createUser(
            @PathVariable("fn") String first,
            @PathVariable("ln") String last,
            @PathVariable("un") String uname,
            @PathVariable("pw") String pass,
            @PathVariable("em") String email,
            @PathVariable("db") Date dob) {
        User user = new User(first, last, uname, pass, email, dob);
        return userRepository.save(user);
    }

    @GetMapping("/orm/find/users")
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @GetMapping("/orm/find/user/{userId}")
    public User findUserById(
            @PathVariable("userId") Integer id) {
        return userRepository.findUserById(id);
    }

    @PutMapping("/orm/users/{userId}")
    public User updateUser(
            @PathVariable("userId") Integer id,
            @RequestBody User userUpdates) {
        User user = userRepository.findUserById(id);
        user.setFirstName(userUpdates.getFirstName());
        user.setLastName(userUpdates.getLastName());
        user.setUsername(userUpdates.getUsername());
        user.setPassword(userUpdates.getPassword());
        user.setEmail(userUpdates.getEmail());
        user.setDateOfBirth(userUpdates.getDateOfBirth());
        return userRepository.save(user);
    }

    @GetMapping("/orm/delete/user/{userId}")
    public void deleteUser(
            @PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
    }
}
