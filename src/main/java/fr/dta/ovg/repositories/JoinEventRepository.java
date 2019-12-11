package fr.dta.ovg.repositories;

import fr.dta.ovg.entities.JoinEvent;
import org.springframework.data.jpa.repository.JpaRepository;

/** Join Event Repository extends Jpa Repository. */
public interface JoinEventRepository extends JpaRepository<JoinEvent, Long> {

}
