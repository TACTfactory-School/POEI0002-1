package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.ovg.exceptions.NotFoundException;

public abstract class FixtureCheck<R extends JpaRepository<?, ?>> implements Fixture {

    @Autowired
    protected R repository;

    @Override
    public void load() throws NotFoundException {
        if (this.repository.count() == 0) {
            this.loadIfNoData();
        }
    }

    protected abstract void loadIfNoData() throws NotFoundException;
}
