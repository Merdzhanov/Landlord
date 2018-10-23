package com.landlord.controllers;

import com.landlord.models.Estate;
import com.landlord.services.EstateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estates")
public class EstateRestController {
    private final EstateServiceImpl service;

    @Autowired
    public EstateRestController(EstateServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void create(@RequestBody Estate estate) {
        service.create(estate);
    }

    @GetMapping
    public List getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Estate getById(@PathVariable int id) {
        return service.getById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Estate estate) {
        service.update(id, estate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
