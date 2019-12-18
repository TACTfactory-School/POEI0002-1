/* Notification Setting Service Implementation class.
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

import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.NotificationRepository;
import fr.dta.ovg.services.user.UserDeleteService;

/** Notification Setting Service Implementation class.*/
@Service
public class NotificationCrudServiceImpl implements NotificationCrudService {

    /** Link to the entity repository. */
    @Autowired
    private NotificationRepository repository;

    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteService.class);

    /** Get All Notifications.
     * @see Notification.*/
    @Override
    public List<Notification> getAll() {

        LOG.debug("Get All Notifications");
        return this.repository.findAll();
    }

    /** Get One Notification.
     * @param id : id of the notification.
     * @return the notification.*/
    @Override
    public Notification getOne(final long id) throws NotFoundException {

        LOG.debug("Get one Notification");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /** Create Notification function.
     * @param notification : Notification entity.
     * @return the saved notification.*/
    @Override
    public Notification create(final Notification notification) {

        LOG.debug("Create Notification");
        return this.repository.save(notification);
    }

    /** Delete Notification function.
     * @param id : id of the notification.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete Notification");

        Notification notification = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(notification);
    }
}
