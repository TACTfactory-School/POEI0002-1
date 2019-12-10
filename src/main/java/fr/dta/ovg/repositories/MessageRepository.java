package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.ovg.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Long>{

}
