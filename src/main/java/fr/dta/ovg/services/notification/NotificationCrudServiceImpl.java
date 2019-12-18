/* Notification Setting Service Implementation class.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /** {@inheritDoc}.*/
    @Transactional(readOnly = true)
    @Override
    public Page<Notification> getAll(final Pageable pageable, final Long userId) {

        final Pageable pageableFinal = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        LOG.debug("Get All Notifications");

        return this.repository.findAllByUserId(pageableFinal, userId);
    }

    /** {@inheritDoc}.*/
    @Override
    public Notification getOne(final long id) throws NotFoundException {

        LOG.debug("Get one Notification");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /** {@inheritDoc}.*/
    @Override
    public Notification create(final Notification notification) {

        LOG.debug("Create Notification");
        return this.repository.save(notification);
    }

    /** {@inheritDoc}.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete Notification");

        Notification notification = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(notification);
    }
}
