package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.ovg.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
