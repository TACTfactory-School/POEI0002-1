package fr.dta.ovg.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.UserFriend;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserFriendRepository;
import fr.dta.ovg.services.UserFriendCrudService;

/** User Friend CRUD service Implementation.*/
@Service
public class UserFriendCrudServiceImpl implements UserFriendCrudService {

    /** Link to entity repository. */
    @Autowired
    private UserFriendRepository repository;

    /** Logger instance. */
    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteService.class);

    /**{@inheritDoc}*/
    @Transactional(readOnly = true)
    @Override
    public Page<UserFriend> getAll(final Pageable pageable, final Long userId) {

        LOG.debug("Get All User's friends.");
        return this.repository.findAllByUserId(pageable, userId);
    }

    /**{@inheritDoc}*/
    @Override
    public UserFriend getOne(final long id) throws NotFoundException {

        LOG.debug("Get one User's friend.");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /**{@inheritDoc}*/
    @Override
    public UserFriend create(final UserFriend userFriend) {

        LOG.debug("Create UserFriend");
        return this.repository.save(userFriend);
    }

    /**{@inheritDoc}*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete UserFriend");

        UserFriend userFriend = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(userFriend);
    }

    /**{@inheritDoc}*/
    @Override
    public boolean existsByUsernameIgnoreCaseAndIdNot(final String username, final Long friendRequestId) {
        return false;
    }
}

