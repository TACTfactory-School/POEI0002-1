package com.ovg.app.aexamples.jdbc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovg.app.aexamples.jdbc.entities.Event;
import com.ovg.app.aexamples.jdbc.repositories.EventRepository;

@RestController
@RequestMapping("event")
public class EventController extends CrudController<Event, EventRepository> {
}
