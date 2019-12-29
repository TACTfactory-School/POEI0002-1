/* Message Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */

package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.contracts.FixturesContract;
import fr.dta.ovg.entities.Message;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.MessageRepository;
import fr.dta.ovg.services.MessageCrudService;
import fr.dta.ovg.services.UserCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class MessageFixtureService extends FixtureCheck<MessageRepository> {

    /** Link to Message CRUD Service. */
    private final MessageCrudService messageService;

    /** Link to User CRUD Service. */
    private final UserCrudService userService;

    /** Local Constructor.
     * @param messageService : @see MessageCrudService.
     * @param userService : @see UserCrudService.*/
    public MessageFixtureService(
            @Autowired final MessageCrudService messageService,
            @Autowired final UserCrudService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    /** Fixtures are loaded only if no data.
     * @throws NotFoundException : Message entity not found.*/
    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.build("Salut Pamwamba, Comment tu vas ?",
                    userService.getOne(FixturesContract.COLIN),         userService.getOne(FixturesContract.SAMY));
        this.build("Salut tu viens demain ?",
                    userService.getOne(FixturesContract.SAMY),          userService.getOne(FixturesContract.COLIN));
        this.build("Hello, on se retrouve là bas ?",
                    userService.getOne(FixturesContract.FAB),           userService.getOne(FixturesContract.COLIN));
        this.build("C'est toi qui à créé l'event sur Nantes ?",
                    userService.getOne(FixturesContract.SAMY),          userService.getOne(FixturesContract.FAB));
        this.build("Je viens de créé, tu peux rejoindre si tu veux.",
                    userService.getOne(FixturesContract.FAB),           userService.getOne(FixturesContract.COLIN));

        for (int i = 1; i < FixturesContract.NB_REAL; i++) {
            this.build("Hey, t'es là le 6 janvier ?)",
                        userService.getOne(FixturesContract.NB_RAND),
                        userService.getOne(i));
            this.build("Salut c'est Polo !",
                        userService.getOne(FixturesContract.NB_RAND - i),
                        userService.getOne(i));
        }
    }

    /** Message Builder.
     * @param msg : the message.
     * @param userEmitter : User who emit.
     * @param userReceiver : User who receive.*/
    private void build(final String msg, final User userEmitter, final User userReceiver) {

        final Message message = new Message();

        message.setMessage(msg);
        message.setUserEmitter(userEmitter);
        message.setUserReceiver(userReceiver);

        messageService.create(message);
    }

}
