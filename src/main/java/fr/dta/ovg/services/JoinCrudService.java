package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Join;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.event.EventCrudServiceImpl;

public interface JoinCrudService {
    /**
     * Returns all {@link RendezVous rendez-vous}.
     *
     * @return
     */
    List<Join> getAll();

    /**
     * Deletes the {@link RendezVous rendez-vous} for given
     * {@link Join#id id}.
     *
     * @param id
     *            The id of the {@link Join inscription} to delete.
     * @throws NotFoundException
     *             Throws if no {@link Join inscription} entity exists
     *             for given {@code id}.
     */
    void delete(final long id) throws NotFoundException;

    /**
     * Get one Event entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Event : entity.
     * @see EventCrudServiceImpl EventCrudServiceImpl
     * */
    Join getOne(long id) throws NotFoundException;

    /**
     * Saves in database the given {@link RendezVous rendez-vous}.
     *
     * @param entity
     *            The built entity.
     * @return The entity after hydratation.
     */
    Join create(final Join entity);
}
