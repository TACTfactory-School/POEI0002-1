/* Notification Settings Implementation class.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.notification;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.NotificationSetting;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.NotificationSettingRepository;
import fr.dta.ovg.services.user.UserDeleteService;

/** Notification Settings Implementation class. CRUD Service.*/
@Service
public class NotificationSettingCrudServiceImpl implements NotificationSettingCrudService {

    /** Link to the entity repository. */
    @Autowired
    private NotificationSettingRepository repository;

    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteService.class);

    /** Get All Notifications Settings.
     * @see NotificationSetting.*/
    @Override
    public List<NotificationSetting> getAll() {

        LOG.debug("Get All Notifications settings.");
        return this.repository.findAll();
    }

    /** Get One Notification Settings.
     * @param id : id of the notification setting.
     * @return the notification settings.*/
    @Override
    public NotificationSetting getOne(final long id) throws NotFoundException {

        LOG.debug("Get one Notification setting.");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /** Create Notification setting function.
     * @param notificationSetting : NotificationSetting entity.
     * @return the saved notification setting.*/
    @Override
    public NotificationSetting create(final NotificationSetting notificationSetting) {

        LOG.debug("Create Notification setting.");
        return this.repository.save(notificationSetting);
    }

    /** Delete Notification setting function.
     * @param id : id of the notification setting.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete Notification setting.");

        NotificationSetting notificationSetting = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(notificationSetting);
    }
}

