/* Message CRUD Service Implementation Class.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.Message;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.MessageRepository;
import fr.dta.ovg.services.user.UserDeleteService;

/** Message CRUD Service Implementation Class.*/
@Service
public class MessageCrudServiceImpl implements MessageCrudService {

    /** Link to entity repository.*/
    @Autowired
    private MessageRepository repository;

    /** Local Logger declaration. */
    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteService.class);

    /** {@inheritDoc}.*/
    @Transactional(readOnly = true)
    @Override
    public Page<Message> getAll(final Pageable pageable, final Long userId) {

        //final Pageable pageableFinal = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        LOG.debug("Get All Messages");

        return this.repository.findAllByUserId(pageable, userId);    }

    /** {@inheritDoc}.*/
    @Override
    public Message getOne(final long id) throws NotFoundException {

        LOG.debug("Get one Message");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /** {@inheritDoc}.*/
    @Override
    public Message create(final Message message) {

        LOG.debug("Create Message");
        return this.repository.save(message);
    }

    /** {@inheritDoc}.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete Message");

        Message message = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(message);
    }
}
