package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.JoinEvent;
import fr.dta.ovg.exceptions.NotFoundException;

public interface JoinCrudService {
    /**
     * Returns all {@link RendezVous rendez-vous}.
     *
     * @return
     */
    List<JoinEvent> getAll();

    /**
     * Deletes the {@link RendezVous rendez-vous} for given
     * {@link JoinEvent#id id}.
     *
     * @param id
     *            The id of the {@link JoinEvent inscription} to delete.
     * @throws NotFoundException
     *             Throws if no {@link JoinEvent inscription} entity exists
     *             for given {@code id}.
     */
    void delete(long id) throws NotFoundException;

    /**
     * Get one Event entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Event : entity.
     * @see EventCrudServiceImpl EventCrudServiceImpl
     * */
    JoinEvent getOne(long id) throws NotFoundException;

    /**
     * Saves in database the given {@link RendezVous rendez-vous}.
     *
     * @param entity
     *            The built entity.
     * @return The entity after hydratation.
     */
    JoinEvent create(JoinEvent entity);
}
