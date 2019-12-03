package com.ovg.app.controllers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovg.app.entities.Event;
import com.ovg.app.repositories.EventRepository;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventRepository repository;


    @GetMapping
    public List<Event> getAll() throws SQLException {
        return this.repository.findAll();
    }
    @GetMapping("/{id}")
    public Event getOne(@PathVariable int id) throws SQLException {
        return this.repository.findById(id);
    }

    @PutMapping
    public void putOne() throws SQLException {
        this.repository.insertOne("Raclette", "miam c du sport la raclette", "moi");
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id) throws SQLException {
        this.repository.deleteById(id);
    }
}
