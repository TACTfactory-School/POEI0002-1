package fr.dta.ovg.services;

import javax.transaction.Transactional;

public interface Fixture {
    @Transactional
    void load();
}
