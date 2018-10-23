package com.landlord.controllers;


import com.landlord.models.User;
import com.landlord.models.base.UserType;
import com.landlord.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserServiceImpl service;

    @Autowired
    public UserRestController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void create(@RequestBody User user) {
        service.create(user);
    }

    @GetMapping
    public List getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/type/{type}")
    List<User> getByType(@PathVariable UserType type) {
        return service.getByType(type);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody User user) {
        service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
