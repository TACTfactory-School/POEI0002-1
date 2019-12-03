package fr.dta.ovg.security.services;

import javax.validation.Valid;

import fr.dta.ovg.security.entities.SecurityUser;

public interface UserService {

    void save(@Valid SecurityUser user);

    SecurityUser findByUsername(String login);
}
