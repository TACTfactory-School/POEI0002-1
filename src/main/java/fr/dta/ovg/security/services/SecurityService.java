package fr.dta.ovg.security.services;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
