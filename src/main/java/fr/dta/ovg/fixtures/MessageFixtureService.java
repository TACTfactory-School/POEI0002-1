package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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

    private final MessageCrudService messageService;

    private final UserCrudService userService;


    public MessageFixtureService(
            @Autowired final MessageCrudService messageService,
            @Autowired final UserCrudService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }
    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.build("Salut Pamwamba, Comment tu vas ?",                  userService.getOne(2), userService.getOne(1));
        this.build("Salut tu viens demain ?",                           userService.getOne(1), userService.getOne(2));
        this.build("Hello, on se retrouve là bas ?",                    userService.getOne(3), userService.getOne(2));
        this.build("C'est toi qui à créé l'event sur Nantes ?",         userService.getOne(1), userService.getOne(3));
        this.build("Je viens de créé, tu peux rejoindre si tu veux.",   userService.getOne(3), userService.getOne(2));

        for (int i = 3; i < 4; i++) {
            this.build("Bienvenue sur OVG.fr :)",   userService.getOne(i + 1), userService.getOne(i));
            this.build("Salut c'est Polo !",        userService.getOne(i + 1), userService.getOne(i));
        }
    }

    private void build(final String msg, final User userEmitter, final User userReceiver) {

        final Message message = new Message();

        message.setMessage(msg);
        message.setUserEmitter(userEmitter);
        message.setUserReceiver(userReceiver);

        messageService.create(message);
    }

}
