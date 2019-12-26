/* Hobby Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Hobby;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.HobbyRepository;
import fr.dta.ovg.services.HobbyCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class HobbyFixtureService extends FixtureCheck<HobbyRepository> {

    /** Link to Hobby CRUD Service. */
    private final HobbyCrudService hobbyService;

    /** Local Constructor.
     * Link to Event Create Service.
     * @param hobbyService : @see HobbyCrudService.*/
    public HobbyFixtureService(@Autowired final HobbyCrudService hobbyService) {
        this.hobbyService = hobbyService;
    }


    /** Insert initial data - Create-drop mode will erasing old data in the DB at every run.
     * Fixtures are loaded only if no data.
     * @throws NotFoundException : Hobby entity not found.*/
    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.build("Bénévolat");
        this.build("Sport");
        this.build("Cinéma / Séries TV");
        this.build("Musique");
        this.build("Nature");
        this.build("Animaux");
        this.build("Jardinage");
        this.build("Jeux-vidéos");
        this.build("PC Tunning");
        this.build("Nouvelles technologies");
        this.build("Cuisine");
        this.build("Lecture");
        this.build("Spectacles");
        this.build("Peinture");
        this.build("Hacking");
        this.build("Dessin");
    }

    /** Hobby Builder.
     * @param label : hobby name.*/
    private void build(final String label) {

        final Hobby hobby = new Hobby();

        hobby.setLabel(label);

        hobbyService.create(hobby);
    }
}
