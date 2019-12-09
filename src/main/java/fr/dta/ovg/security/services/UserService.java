package fr.dta.ovg.security.services;

import javax.validation.Valid;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.security.entities.SecurityUser;

public interface UserService {

    void save(@Valid SecurityUser user);

    User findByUsername(String login);
}
