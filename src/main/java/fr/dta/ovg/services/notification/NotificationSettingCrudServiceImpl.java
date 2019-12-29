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
import org.springframework.transaction.annotation.Transactional;

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

    /** Local Logger instance declaration. */
    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteService.class);

    /** {@inheritDoc}.*/
    @Transactional(readOnly = true)
    @Override
    public List<NotificationSetting> getAll() {

        LOG.debug("Get All Notifications settings.");
        return this.repository.findAll();
    }

    /** {@inheritDoc}.*/
    @Override
    public NotificationSetting getOne(final long id) throws NotFoundException {

        LOG.debug("Get one Notification setting.");
//        return this.repository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException());
        return this.repository.findOneByUserId(id);
    }

    /** {@inheritDoc}.*/
    @Override
    public NotificationSetting create(final NotificationSetting notificationSetting) {

        LOG.debug("Create Notification setting.");
        return this.repository.save(notificationSetting);
    }

    /** {@inheritDoc}.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete Notification setting.");

        NotificationSetting notificationSetting = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(notificationSetting);
    }

    /** {@inheritDoc}.*/
    @Override
    public NotificationSetting getOneByUserId(final long userId) {
        return this.repository.findOneByUserId(userId);
    }
}

