package com.ovg.app.repositories;

import com.ovg.app.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    boolean existsByLabelIgnoreCase(String label);

    boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);

//    @Query("SELECT p FROM PokemonSpecies p WHERE p.id = ?1")
//    PokemonSpecies findOne(Long id);
//    @Query("SELECT p FROM PokemonSpecies p WHERE p.id = :myId")
//    PokemonSpecies findOne(@Param("myId") Long id);

    @Query("SELECT COUNT(e) > 0"
            + " FROM Event e"
            + " WHERE LOWER(e.label) = LOWER(:#{#s.label})"
            + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
    boolean existsByLabel(@Param("s") Event event);
}

/*
 * CORRECTIF JDBC
 * import com.ovg.app.repositories.OvgRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;

@Repository
public class EventRepository extends OvgRepository<Event> {

    @Override
    protected String getTableName() {
        return "app_events";
    }

    @Override
    protected List<String> getColumnNames() {
        return Arrays.asList("id", "label", "event_description", "author");
    }

    @Override
    protected PreparedStatement fill(final PreparedStatement stmt, final Event e) throws SQLException {
        stmt.setInt(1, e.getId());
        stmt.setString(2, e.getLabel());
        stmt.setString(3, e.getDescription());
        stmt.setString(4, e.getAuthor());

        return null;
    }

    @Override
    protected Event fill(final ResultSet rs) throws SQLException {
        final Event result = new Event();

        result.setId(rs.getInt("id"));
        result.setLabel(rs.getString("label"));
        result.setDescription(rs.getString("event_description"));
        result.setAuthor(rs.getString("author"));

        return result;
    }
}
/*
 *		// OLD
        import java.sql.Connection;
        import java.sql.Statement;
        import java.util.ArrayList;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
 *		EventRepository extends OvgRepository<Event>
 *
        @Autowired
        private EntityManager manager;

        private Connection connection() {
            return this.manager.getConnection();
        }

        public int getLenght() throws SQLException{
            final Statement stm = this.connection().createStatement();
            final String query = String.format("SELECT COUNT(e.id) FROM event e");
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            final int dbLenght = rs.getInt(1);
            return dbLenght;
        }

        public boolean checkLabel(String label) throws SQLException{
            final boolean check;
            final Statement stm = this.connection().createStatement();
            final String query = String.format("SELECT e.label FROM event e");
            if (label.equals(stm.executeUpdate(query))){
                check = true;
            } else {
                check = false;
            }
            return check;
        }

        private void insertOne(String label, String description, String author) throws SQLException {
            final Statement stm = this.connection().createStatement();

            final String query = String.format("INSERT INTO event (label, event_description, author)"
                                              + "VALUES (\"%s\", \"%s\", \"%s\")",
                                                      label, description, author);

            System.out.println("Query: " + query);
            stm.executeUpdate(query);
        }

        public void deleteOneByID(final int id) throws SQLException{
            final Statement stm = this.connection().createStatement();
            final String query = String.format("DELETE FROM event WHERE id = %d", id);
            System.out.println("Query: " + query);

            if (stm.executeUpdate(query) == 0) {
                System.out.println("L'ID saisi n'existe pas dans la BDD !");
            }
        }

        public void updateOne(Event e, int id) throws SQLException{
            final Statement stm = this.connection().createStatement();
            final String query = String.format("UPDATE event SET `label` = '%s',"
                                                              + "`event_description` = '%s',"
                                                              + "`author` = '%s'"
                                                              + "WHERE id = %d",
                                                            e.getLabel(),
                                                            e.getDescription(),
                                                            e.getAuthor(),
                                                            id);
            stm.executeUpdate(query);
        }

        public void deleteOneByLabel(String label) throws SQLException{
            final Statement stm = this.connection().createStatement();
            final String query = String.format("DELETE FROM event e WHERE LOWER(e.label) LIKE '%s'",
                                                label.toLowerCase());
            System.out.println("Query: " + query);
            stm.executeUpdate(query);
        }

        public List<Event> findAll() throws SQLException {
            final List<Event> result = new ArrayList<Event>();
            final Statement stm = connection().createStatement();
            final String query = "SELECT * FROM event";

            System.out.println("Query: " + query);
            final ResultSet eventRS = stm.executeQuery(query);

            while (eventRS.next()) {
                final int id = eventRS.getInt("id");
                final String label = eventRS.getString("label");
                final String description = eventRS.getString("event_description");
                final String author = eventRS.getString("author");

                result.add(new Event(id, label, description, author));
            }
            return result;
        }

        public void save(Event e) throws SQLException{
            insertOne(e.getLabel(), e.getDescription(), e.getAuthor());
//          return new Event(1, e.getLabel(), e.getDescription(), e.getAuthor());
        }
*/

