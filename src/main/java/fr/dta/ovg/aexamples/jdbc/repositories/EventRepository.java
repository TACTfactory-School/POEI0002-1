package com.ovg.app.aexamples.jdbc.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ovg.app.aexamples.jdbc.entities.Event;

@Repository
public class EventRepository extends OvgRepository<Event> {

    @Override
    protected String getTableName() {
        return "app_events";
    }

    @Override
    protected List<String> getColumnNames() {
        return Arrays.asList("id", "label", "description", "author");
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
        result.setDescription(rs.getString("description"));
        result.setAuthor(rs.getString("author"));

        return result;
    }
}
