/* Join Controller Class
 * @author Colin Cerveaux @C-ambium
 * Rest Mapping and SpringBoot mapping join controller
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

import fr.dta.ovg.entities.Join;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.JoinCrudService;

@RestController
@RequestMapping("/inscription")
public class JoinController {

    /** Link to Join CRUD Service. */
    @Autowired
    private JoinCrudService service;
    /**
     * Get All function. <br>
     * GET - HTTP.
     *
     * @return List of all Users who joined Events.
     */
    @GetMapping
    public List<Join> getAll() {
        return this.service.getAll();
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id: number of the selected Join.
     * @return Entity Join.
     * @throws NotFoundException
     */
    @GetMapping("{id}")
    public Join getOne(@PathVariable Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create a Join.<br>
     * POST - HTTP.
     * @param Join entity.
     * @return the created object Join.
     * @throws BadRequestException
     */
    @PostMapping
    public Join create(@Valid @RequestBody final Join inscription) throws BadRequestException {
        return this.service.create(inscription);
    }

    /**
     * Update an Join. <br>
     * PUT - HTTP.
     * @param id: number of the selected event.
     * @param Join entity.
     * @return the updated Join object.
     * @throws BadRequestException
     * @throws NotFoundException
     */
    @PutMapping("{id}")
    public Join update(@PathVariable Long id, @Valid @RequestBody Join inscription)
            throws BadRequestException, NotFoundException {

        final Join entity = this.service.getOne(id);

        // TODO: Use mapper.
        // ObjectMapper mapper = new ObjectMapper();
        // ---------
        return this.service.create(entity);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id: number of the selected Join.
     * @throws NotFoundException
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
