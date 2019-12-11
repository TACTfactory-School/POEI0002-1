package fr.dta.ovg.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.Hobby;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.HobbyRepository;
import fr.dta.ovg.services.user.UserDeleteService;

@Service
public class HobbyCrudServiceImpl implements HobbyCrudService{

    @Autowired
    HobbyRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UserDeleteService.class);

    @Override
    public List<Hobby> getAll() {

        log.debug("Get All Hobbies");
        return this.repository.findAll();
    }

    @Override
    public Hobby getOne(long id) throws NotFoundException {

        log.debug("Get one Hobby");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Hobby create(final Hobby hobby) {

        log.debug("Create Hobby");
        return this.repository.save(hobby);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        log.debug("Delete one Hobby by ID");

        Hobby hobby = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(hobby);
    }

    @Override
    public boolean existsByLabel(final Hobby hobby) {

        return this.repository.existsByLabel(hobby);
    }
}
