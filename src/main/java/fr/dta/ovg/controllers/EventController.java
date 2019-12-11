/* Event Controller Class
 * @author Colin Cerveaux @C-ambium
 * Rest Mapping and SpringBoot mapping event controller
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.EventCrudService;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("api/v1/event")
@Api(value = "Event Management System", tags = "Event")
public class EventController {

    /** Link to Event CRUD Service. */
    @Autowired
    private EventCrudService service;

    /**
     * Get All function. <br>
     * GET - HTTP.
     * @return List of all Events.
     */
    @GetMapping
    public List<Event> getAll() {
        return this.service.getAll();
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected event.
     * @return Entity Event.
     * @throws NotFoundException
     */
    @GetMapping("{id}")
    public Event getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create an Event.<br>
     * POST - HTTP.
     * @param event entity.
     * @return the created object event.
     * @throws BadRequestException
     */
    @PostMapping
    public Event create(@Valid @RequestBody final Event event) throws BadRequestException {
        return this.service.create(event);
    }

    /**
     * Update an Event. <br>
     * PUT - HTTP.
     * @param id : number of the selected event.
     * @param event : entity.
     * @return the updated event object.
     * @throws BadRequestException
     * @throws NotFoundException
     */
    @PutMapping("{id}")
    public Event update(@PathVariable final Long id, @Valid @RequestBody final Event event)
            throws BadRequestException, NotFoundException {

        final Event entity = this.service.getOne(id);

        //  Use mapper.
        //  ObjectMapper mapper = new ObjectMapper();
        // ---------
        entity.setLabel(event.getLabel());
        entity.setCreator(event.getCreator());
        entity.setDescription(event.getDescription());

        return this.service.create(entity);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected event.
     * @throws NotFoundException
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
