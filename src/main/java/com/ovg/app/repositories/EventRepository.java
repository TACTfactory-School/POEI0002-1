package com.ovg.app.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ovg.app.entities.Event;

@Repository
public class EventRepository {

    @Autowired
    private EntityManager manager;

    private Connection connection() {
        return this.manager.getConnection();
    }

    public void insertOne(String label, String description, String author) throws SQLException {
        final Statement stm = this.connection().createStatement();

        final String query = String.format("INSERT INTO ovg_event (label, description, author) VALUES (\"%s\", \"%s\", \"%s\")",
                label, description, author);

        System.out.println("Query: " + query);
        stm.executeUpdate(query);
    }

    public void deleteById(int id) throws SQLException {
        final Statement stm = this.connection().createStatement();

        final String query = String.format("DELETE FROM ovg_event WHERE id = %d" , id);
        System.out.println("Query:" + query);
        stm.executeUpdate(query);
    }

    public List<Event> findAll() throws SQLException {
        final List<Event> result = new ArrayList<Event>();
        final Statement stm = connection().createStatement();
        final String query = "SELECT * FROM ovg_event";

        System.out.println("Query: " + query);
        final ResultSet eventRS = stm.executeQuery(query);

        while (eventRS.next()) {
            final int id = eventRS.getInt("id");
            final String label = eventRS.getString("label");
            final String description = eventRS.getString("description");
            final String author = eventRS.getString("author");

            result.add(new Event(id, label, description, author));
        }

        return result;
    }
    public Event findById(int idEvent) throws SQLException {
        Event result = new Event();

        final Statement stm = connection().createStatement();

        final String query = String.format("SELECT * FROM ovg_event WHERE id = %d" , idEvent);

        System.out.println("Query: " + query);
        final ResultSet eventRS = stm.executeQuery(query);
        eventRS.next();
        final int id = eventRS.getInt("id");
        final String label = eventRS.getString("label");
        final String description = eventRS.getString("description");
        final String author = eventRS.getString("author");
        result = new Event(id, label, description, author);
        return result;
    }
}
