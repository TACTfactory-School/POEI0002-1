package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.NotFoundException;

public interface EventCrudService {

    List<Event> getAll();

    Event getOne(long id) throws NotFoundException;

    Event create(Event event);

    void delete(long id) throws NotFoundException;

    boolean existsByLabel(Event event);

    boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);
}
