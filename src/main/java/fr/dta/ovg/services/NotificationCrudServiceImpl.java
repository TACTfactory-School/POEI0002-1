package fr.dta.ovg.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.NotificationRepository;
import fr.dta.ovg.services.user.UserDeleteService;

@Service
public class NotificationCrudServiceImpl implements NotificationCrudService{

    @Autowired
    NotificationRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UserDeleteService.class);

    @Override
    public List<Notification> getAll() {

        log.debug("Get All Notifications");
        return this.repository.findAll();
    }

    @Override
    public Notification getOne(long id) throws NotFoundException {

        log.debug("Get one Notification");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Notification create(final Notification notification) {

        log.debug("Create Notification");
        return this.repository.save(notification);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        log.debug("Delete Notification");

        Notification notification = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(notification);
    }
}
