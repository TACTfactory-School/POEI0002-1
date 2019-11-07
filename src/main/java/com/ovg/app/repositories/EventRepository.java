package com.ovg.app.repositories;

import com.ovg.app.entities.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository extends OvgRepository<Event>{

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
}
