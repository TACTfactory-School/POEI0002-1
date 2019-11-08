package com.ovg.app.services;

import java.util.List;

import com.ovg.app.entities.Event;
import com.ovg.app.repositories.EventRepository;

public class CrudEventService extends CrudService<Event, EventRepository> {

    @Override
    public List<Event> findAll() {
        return super.findAll();
    }
}
