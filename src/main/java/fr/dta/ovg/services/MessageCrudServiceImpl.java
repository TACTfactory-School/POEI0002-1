package fr.dta.ovg.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.Message;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.MessageRepository;
import fr.dta.ovg.services.user.UserDeleteService;

@Service
public class MessageCrudServiceImpl implements MessageCrudService{

    @Autowired
   MessageRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UserDeleteService.class);

    @Override
    public List<Message> getAll() {

        log.debug("Get All Messages");
        return this.repository.findAll();
    }

    @Override
    public Message getOne(final long id) throws NotFoundException {

        log.debug("Get one Message");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Message create(final Message message) {

        log.debug("Create Message");
        return this.repository.save(message);
    }

    @Override
    public void delete(final long id) throws NotFoundException {
        log.debug("Delete Message");

        Message message = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(message);
    }
}
