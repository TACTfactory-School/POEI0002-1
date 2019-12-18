/* Event Controller Class.
 * @author Colin Cerveaux @C-ambium.
 * Rest Mapping and SpringBoot mapping event controller.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

/** Event Controller Class.*/
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
    * @param page the page number.
    * @param quantity the quantity of return per page.
    * @param search : String to prpcess search.
    * @return Page page number with quantity asked.
    */
    @GetMapping
    public Page<Event> getAll(final int page, final int quantity, final String search) {

        Pageable pageable = PageRequest.of(page, quantity);

        return this.service.getAll(pageable, search);
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected event.
     * @return Entity Event.
     * @throws NotFoundException : Entity event not found.
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
     * @throws BadRequestException : Incorrect request.
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
     * @throws BadRequestException : Incorrect request.
     * @throws NotFoundException : Event entity not found.
     */
    @PutMapping("{id}")
    public Event update(@PathVariable final Long id, @Valid @RequestBody final Event event)
            throws BadRequestException, NotFoundException {

        final Event entity = this.service.getOne(id);

        //  Use mapper.
        //  ObjectMapper mapper = new ObjectMapper();
        // ---------
        entity.setLabel(event.getLabel());
        entity.setDescription(event.getDescription());
        entity.setStartAt(event.getStartAt());
        entity.setAddress(event.getAddress());
        entity.setPostcode(event.getPostcode());
        entity.setCity(event.getCity());
        entity.setNbPlaceMax(event.getNbPlaceMax());
        entity.setImg(event.getImg());

        return this.service.create(entity);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected event.
     * @throws NotFoundException : Event entity not found.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
