package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Message;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.MessageRepository;
import fr.dta.ovg.services.MessageCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class MessageFixtureService extends FixtureCheck<MessageRepository>{

    private final MessageCrudService messageService;

    public MessageFixtureService(@Autowired final MessageCrudService messageService) {
        this.messageService = messageService;
    }
    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.build("Salut Pamwamba, Comment tu vas ?");
        this.build("Salut tu viens demain ?");
        this.build("Hello, on se retrouve là bas ?");
        this.build("C'est toi qui à créé l'event sur Nantes ?");
        this.build("Je viens de créé, tu peux rejoindre si tu veux.");
    }

    private void build(String msg) {

        final Message message = new Message();

        message.setMessage(msg);

        messageService.create(message);
    }

}
