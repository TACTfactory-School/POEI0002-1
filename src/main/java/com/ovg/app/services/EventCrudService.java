package com.ovg.app.services;

import java.util.List;



import com.ovg.app.entities.Event;
import com.ovg.app.exceptions.NotFoundException;

public interface EventCrudService {

    List<Event> getAll();

    Event getOne(long id) throws NotFoundException;

    Event create(Event event);

    void delete(long id) throws NotFoundException;

    boolean existsByLabel(Event event);

    boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);
}
