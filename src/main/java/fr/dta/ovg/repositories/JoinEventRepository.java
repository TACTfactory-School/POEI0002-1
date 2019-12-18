package fr.dta.ovg.repositories;

import fr.dta.ovg.entities.JoinEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Join Event Repository extends Jpa Repository. */
@Repository
public interface JoinEventRepository extends JpaRepository<JoinEvent, Long> {

}
