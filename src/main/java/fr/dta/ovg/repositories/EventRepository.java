/* Entity base class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.Event;

/** Event Repository extends Jpa Repository. */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
