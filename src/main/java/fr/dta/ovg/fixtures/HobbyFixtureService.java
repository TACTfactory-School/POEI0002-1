/* Hobby Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Hobby;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.entities.UserHobby;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.HobbyRepository;
import fr.dta.ovg.repositories.UserHobbyRepository;
import fr.dta.ovg.services.HobbyCrudService;
import fr.dta.ovg.services.user.UserCrudServiceImpl;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class HobbyFixtureService extends FixtureCheck<HobbyRepository> {

    /** Link to Hobby CRUD Service. */
    private final HobbyCrudService hobbyService;

    /** Link to UserHobby Repository. */
    private final UserHobbyRepository userHobbyRepo;

    /** Link to User CRUD Service. */
    private final UserCrudServiceImpl userService;

    /** Number of initial real hobbies minus one (because random object can hit zero).*/
    private final static byte NB_HOBBIES = 15;

    /** Local Constructor.
     * Link to Event Create Service.
     * @param hobbyService : @see HobbyCrudService.
     * @param userHobbyRepo : @see UserHobbyRepository.
     * @param userService : @see UserCrudServiceImpl.*/
    public HobbyFixtureService(
            @Autowired final HobbyCrudService hobbyService,
            @Autowired final UserHobbyRepository userHobbyRepo,
            @Autowired final UserCrudServiceImpl userService) {
        this.hobbyService = hobbyService;
        this.userHobbyRepo = userHobbyRepo;
        this.userService = userService;
    }


    /** Insert initial data - Create-drop mode will erasing old data in the DB at every run.
     * Fixtures are loaded only if no data.
     * @throws NotFoundException : Hobby entity not found.*/
    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.loadReal();
        this.loadFake();
    }

    /** Build some real user fixture.*/
    private void loadReal() {
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

    /** Build some fake userHobby fixture.
     * @throws NotFoundException : Entity requested not found.*/
    private void loadFake() throws NotFoundException {

        Random rand = new Random();

        for (int j = 1; j < 100; j++) {
            this.buildUserHobby(
                    userService.getOne(j),
                    hobbyService.getOne(rand.nextInt(NB_HOBBIES) + 1));
        }
    }

    /** UserHobby Builder.
     * @param user : User entity.
     * @param hobby : Hobby entity.*/
    private void buildUserHobby(final User user, final Hobby hobby) {

        final UserHobby userHobby = new UserHobby();

        userHobby.setUser(user);
        userHobby.setHobby(hobby);

        userHobbyRepo.save(userHobby);
    }
}
