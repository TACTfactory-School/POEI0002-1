package fr.dta.ovg.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.Message;

@Repository
public interface MessageRepository  extends JpaRepository<Message, Long>{

}
