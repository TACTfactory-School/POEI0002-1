/* Message Controller Class.
 * @author Colin Cerveaux @C-ambium.
 * Rest Mapping and SpringBoot mapping message controller.
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.ovg.entities.Message;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.MessageCrudService;
import io.swagger.annotations.Api;

/** Message Controller Class.*/
@RestController
@RequestMapping("api/v1/message")
@Api(value = "Message Management System", tags = "Message")
public class MessageController {

    /** Link to Message CRUD Service. */
    @Autowired
    private MessageCrudService service;

    /**
     * Get All function. <br>
     * GET - HTTP.
     * @return List of all Messages.
     */
    @GetMapping
    public List<Message> getAll() {
        return this.service.getAll();
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected Message.
     * @return Entity Message.
     * @throws NotFoundException : Message entity not found.
     */
    @GetMapping("{id}")
    public  Message getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create an Message.<br>
     * POST - HTTP.
     * @param Message entity.
     * @return the created object Message.
     * @throws BadRequestException : Incorrect request.
     */
    @PostMapping
    public  Message create(@Valid @RequestBody final  Message  message) throws BadRequestException {

        return this.service.create(message);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected Message.
     * @throws NotFoundException : Message entity not found.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
