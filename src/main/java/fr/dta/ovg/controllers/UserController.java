/* User Controller Class
 * @author Colin Cerveaux @C-ambium
 * Rest Mapping and SpringBoot mapping user controller
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

import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.UserCrudService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/v1/user")
@Api(value="User Management System", tags = "User")
public class UserController {

    /** Link to Event CRUD Service. */
    @Autowired
    private UserCrudService service;

    /**
     * Get All function. <br>
     * GET - HTTP.
     * @return List of all Users.
     */
    @GetMapping
    public List<User> getAll() {
        return this.service.getAll();
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected event.
     * @return Entity User.
     * @throws NotFoundException
     */
    @GetMapping("{id}")
    public User getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create an User.<br>
     * POST - HTTP.
     * @param event entity.
     * @return the created object User.
     * @throws BadRequestException
     */
    @PostMapping
    public User create(@Valid @RequestBody final User user) throws BadRequestException {
        if (this.service.existsByUsername(user)) { // delete test
            throw new BadRequestException("uniq_name");
        }

        return this.service.create(user);
    }

    /**
     * Update an User. <br>
     * PUT - HTTP.
     * @param id : number of the selected User.
     * @param User : entity.
     * @return the updated User object.
     * @throws BadRequestException
     * @throws NotFoundException
     */
    @PutMapping("{id}")
    public User update(@PathVariable final Long id, @Valid @RequestBody final User user)
            throws BadRequestException, NotFoundException {
        if (this.service.existsByUsernameIgnoreCaseAndIdNot(user.getUsername(), id)) { // delete test
            throw new BadRequestException("uniq_name");
        }

        final User entity = this.service.getOne(id);

        // TODO: Use mapper.
        //  ObjectMapper mapper = new ObjectMapper();
        // ---------
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setBirthdate(user.getBirthdate());

        return this.service.create(entity);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected User.
     * @throws NotFoundException
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }


}
