package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.NotificationSetting;

@Repository
public interface NotificationSettingRepository extends JpaRepository<NotificationSetting, Long>{

}
