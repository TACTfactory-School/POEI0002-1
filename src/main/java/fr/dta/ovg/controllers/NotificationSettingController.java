/* Notification Setting Controller Class.
 * @author Colin Cerveaux @C-ambium.
 * Rest Mapping and SpringBoot mapping notification setting controller.
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

import fr.dta.ovg.entities.NotificationSetting;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.notification.NotificationSettingCrudService;
import io.swagger.annotations.Api;

/** Notification Setting Controller Class.
 * Rest Mapping and SpringBoot mapping notification setting controller.*/
@RestController
@RequestMapping("api/v1/settings")
@Api(value = "Notification Management System", tags = "Notification Settings")
public class NotificationSettingController {

    /** Link to NotificationSetting CRUD Service. */
    @Autowired
    private NotificationSettingCrudService service;

    /** Get All function. <br>GET - HTTP.
     * @return List of all NotificationSetting.*/
    @GetMapping
    public List<NotificationSetting> getAll() {
        return this.service.getAll();
    }

    /** Get One by ID.<br>GET - HTTP.
     * @param id : number of the selected NotificationSetting.
     * @return Entity NotificationSetting.
     * @throws NotFoundException :  NotificationSetting entity not found.*/
    @GetMapping("{id}")
    public  NotificationSetting getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create an NotificationSetting.<br>
     * POST - HTTP.
     * @param notificationSetting : NotificationSetting entity.
     * @return the created object NotificationSetting.
     * @throws BadRequestException : Incorrect request (ie Json Body{}).
     */
    @PostMapping
    public  NotificationSetting create(@Valid @RequestBody final  NotificationSetting  notificationSetting)
            throws BadRequestException {

        return this.service.create(notificationSetting);
    }

    /** Update User Notification Setting. <br>
     * PUT - HTTP.
     * @param id : number of the selected User.
     * @param setting : NotificationSetting entity.
     * @return the updated NotificationSetting object.
     * @throws BadRequestException : Incorrect request.
     * @throws NotFoundException : entity not found exception.*/
    @PutMapping("{id}")
    public NotificationSetting update(
            @PathVariable final Long id,
            @Valid @RequestBody final NotificationSetting setting)
            throws BadRequestException, NotFoundException {

        final NotificationSetting entity = this.service.getOne(id);

        //  Use ObjectMapper.
        entity.setActiveApp(setting.isActiveApp());
        entity.setActiveMail(setting.isActiveMail());
        return this.service.create(entity);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected NotificationSetting.
     * @throws NotFoundException : NotificationSetting entity not found.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
