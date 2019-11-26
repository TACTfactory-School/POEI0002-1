/**
 *
 */
package fr.dta.ovg.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.EventRepository;

/**
 * @author JoeHarms
 *
 */
@Service
public class EventCrudServiceImpl implements EventCrudService {


    @Autowired
    private EventRepository repository;

    @Autowired
    private EventCreateService createService;

    @Autowired
    private EventDeleteService deleteService;

    @Transactional(readOnly = true)
    @Override
    public List<Event> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Event getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional()
    @Override
    public Event create(final Event event) {
        return this.createService.create(event);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        // TODO Auto-generated method stub
        this.deleteService.delete(id);
    }

    @Override
//    @Query("SELECT COUNT(e) > 0"
//            + " FROM Event e"
//            + " WHERE LOWER(e.label) = LOWER(:#{#s.label})"
//            + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
    public boolean existsByLabel(Event event) {
        // TODO Auto-generated method stub
        return this.repository.existsByLabel(event);
    }

    @Override
    public boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id) {
        // TODO Auto-generated method stub
        return false;
    }
}
