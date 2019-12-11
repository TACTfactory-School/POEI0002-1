package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
