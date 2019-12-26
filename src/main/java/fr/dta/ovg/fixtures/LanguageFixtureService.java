/* Language Fixture Service class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity User
 * License : ©2019 All rights reserved.*/

package fr.dta.ovg.fixtures;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Language;
import fr.dta.ovg.entities.LanguageLevel;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.entities.UserLanguage;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.LanguageRepository;
import fr.dta.ovg.repositories.UserLanguageRepository;
import fr.dta.ovg.services.LanguageCrudService;
import fr.dta.ovg.services.user.UserCrudServiceImpl;

/** This class initialize DB with initials languages fixtures data. */
@Component
@Profile("!prod")
public class LanguageFixtureService  extends FixtureCheck<LanguageRepository> {

    /** Link to Language CRUD Service. */
    private final LanguageCrudService langService;

    /** Link to UserLanguage Repository. */
    private final UserLanguageRepository userLanguageRepo;

    /** Link to User CRUD Service. */
    private final UserCrudServiceImpl userService;

    /** Declare new Random object.*/
    private final Random rand = new Random();

    /** LanguageFixtureService Constructor. Initialize Language CRUD service.
     * @param langService : @see LanguageCrudService.
     * @param userLanguageRepo : @see UserLanguageRepository.
     * @param userService : @see UserCrudServiceImpl.*/
    public LanguageFixtureService(
            @Autowired final LanguageCrudService langService,
            @Autowired final UserLanguageRepository userLanguageRepo,
            @Autowired final UserCrudServiceImpl userService) {
        this.langService = langService;
        this.userLanguageRepo = userLanguageRepo;
        this.userService = userService;
    }


    /** Fixtures are loaded only if no data.
     * @throws NotFoundException : Language entity not found.*/
    @Override
    protected void loadIfNoData() throws NotFoundException {

        Stream.of("FRANÇAIS", "ENGLISH", "DEUTSCH", "ITALIANO", "ESPAÑOL", "中国的", "ไทย", "РУССКИЙ")
            .forEach(this::build);

        this.buildUserLanguage(
                this.LanguageLevelStore().get(rand.nextInt(4)),
                this.langService.getOne(rand.nextInt(7) + 1),
                this.userService.getOne(rand.nextInt(99) + 1));
    }

    /** Language Builder Function.
     * @param label : the language label.*/
    private void build(final String label) {

        final Language language = new Language();

        language.setLabel(label);

        langService.create(language);
    }

    /** Build UserLanguage Join table Function.
     * @param level : user language level.
     * @param language : language choosed.
     * @param user : current user.*/
    private void buildUserLanguage(final LanguageLevel level, final Language language, final User user) {

        final UserLanguage userLang = new UserLanguage();

        userLang.setLevel(level);
        userLang.setLanguage(language);
        userLang.setUser(user);

        userLanguageRepo.save(userLang);
    }

    /** User Language Level Storage Function.
     * @return List of Language Level.*/
    private ArrayList<LanguageLevel> LanguageLevelStore() {

        ArrayList<LanguageLevel> level = new ArrayList<LanguageLevel>();

        level.add(LanguageLevel.BEGINNER);
        level.add(LanguageLevel.INTERMEDIATE);
        level.add(LanguageLevel.ADVANCED);
        level.add(LanguageLevel.FLUENT);
        level.add(LanguageLevel.NATIVE);

        return level;
    }
}
