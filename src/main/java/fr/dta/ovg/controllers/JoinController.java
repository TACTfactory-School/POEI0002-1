/* Join Controller Class.
 * @author Colin Cerveaux @C-ambium.
 * Rest Mapping and SpringBoot mapping join controller.
 * License : ©2019 All rights reserved.
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

import fr.dta.ovg.entities.JoinEvent;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.JoinCrudService;

/** Join Controller Class.*/
@RestController
@RequestMapping("api/v1/join")
public class JoinController {

    /** Link to Join CRUD Service. */
    @Autowired
    private JoinCrudService service;
    /**
     * Get All function. <br>
     * GET - HTTP.
     * @return List of all Users who joined Events.
     */
    @GetMapping
    public List<JoinEvent> getAll() {
        return this.service.getAll();
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected Join.
     * @return Entity Join.
     * @throws NotFoundException : (User) Join (Event) entity not found.
     */
    @GetMapping("{id}")
    public JoinEvent getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create a Join.<br>
     * POST - HTTP.
     * @param inscription : JoinEvent entity.
     * @return the created object Join.
     * @throws BadRequestException : Incorrect request.
     */
    @PostMapping
    public JoinEvent create(@Valid @RequestBody final JoinEvent inscription) throws BadRequestException {
        JoinEvent result;
        if (this.service.getOneByEventAndUser(inscription.getEvent().getId(), inscription.getUser().getId()) == null) {
            result = this.service.create(inscription);;
        } else {
            throw new BadRequestException("already_join");
        }
        return result;
    }

    /**
     * Update an Join. <br>
     * PUT - HTTP.
     * @param id : number of the selected event.
     * @param inscription : JoinEvent entity.
     * @return the updated Join object.
     * @throws BadRequestException : Incorrect request.
     * @throws NotFoundException : JoinEvent entity not found.
     */
    @PutMapping("{id}")
    public JoinEvent update(@PathVariable final Long id, @Valid @RequestBody final JoinEvent inscription)
            throws BadRequestException, NotFoundException {

        final JoinEvent entity = this.service.getOne(id);

        // Use ObjectMapper mapper = new ObjectMapper();
        return this.service.create(entity);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected Join.
     * @throws NotFoundException : JoinEvent entity not found.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
