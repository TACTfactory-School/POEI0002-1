package com.ovg.app.aexamples.jdbc.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ovg.app.aexamples.jdbc.entities.Entity;
import com.ovg.app.exceptions.HttpException;
import com.ovg.app.exceptions.NotFoundException;

public abstract class OvgRepository<T extends Entity> {

    private static final String SQL_INSERT = "INSERT INTO %s (%s) VALUES (%s)";
    private static final String SQL_SELECT_ONE = "SELECT * FROM %s WHERE id = ?";

    @Autowired
    private EntityManager manager;

    public List<T> findAll() throws SQLException {
        final List<T> result = new ArrayList<>();
        final Statement stm = connection().createStatement();
        final String query = "SELECT * FROM " + this.getTableName();

        System.out.println("Query: " + query);
        final ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            result.add(this.fill(rs));
        }

        return result;
    }

    public void delete(final int id) throws HttpException {
        if (this.executeUpdate("DELETE FROM sys_user WHERE id = " + id) == 0) {
            throw new NotFoundException("No entity found with id " + id);
        }
    }

    public T save(T entity) throws HttpException {
        Integer id = entity.getId();
        T result = null;

        if (entity.getId() == null) {
            id = this.insert(entity, id);
        } else {
            this.update(entity);
        }

        if (id != null) {
            entity = this.find(id);
        }

        return result;
    }

    public T find(int id) throws HttpException {
        T result = null;

        try (final PreparedStatement selectStmt = this.connection()
                .prepareStatement(String.format(SQL_SELECT_ONE, this.getTableName()))) {
            selectStmt.setInt(1, id);
            final ResultSet selectRs = selectStmt.executeQuery();

            if (selectRs.next()) {
                result = this.fill(selectRs);
            }
        } catch (SQLException e) {
            throw new HttpException(e);
        }

        return result;
    }

    protected Connection connection() {
        return this.manager.getConnection();
    }

    protected void update(T entity) throws HttpException, NotFoundException {
        try (final PreparedStatement stmt = this.connection().prepareStatement(this.generateUpdateQuery())) {
            this.fill(stmt, entity);

            switch (stmt.executeUpdate()) {
            case 0:
                throw new NotFoundException();
            case 1:
                // Ok, nothing to do.
                break;
            default:
                // TODO: use transaction then roolback here.
                throw new HttpException("WTF man!");
            }
        } catch (SQLException e) {
            throw new HttpException(e);
        }
    }

    protected Integer insert(T entity, Integer id) throws HttpException {
        try (final PreparedStatement stmt = this.connection()
                .prepareStatement(this.generateInsertQuery(), Statement.RETURN_GENERATED_KEYS)) {
            this.fill(stmt, entity);

            stmt.executeUpdate();

            final ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new HttpException(e);
        }

        return id;
    }

    private String generateUpdateQuery() {
        final StringBuilder columns = new StringBuilder();
        boolean notFirst = false;

        for (String col : this.getColumnNames()) {
            if (notFirst) {
                columns.append(", ");
            } else {
                notFirst = true;
            }

            columns.append(col);
            columns.append("?");
        }

        return String.format("UPDATE %s SET %s", this.getTableName(), columns.toString());
    }

    private String generateInsertQuery() {
        final StringBuilder params = new StringBuilder();
        final List<String> columnNames = this.getColumnNames();
        final String columns = String.join(", ", columnNames);

        for (int i = 0; i < columnNames.size(); i++) {
            if (i == 0) {
                params.append('?');
            } else {
                params.append(", ?");
            }
        }

        return String.format(SQL_INSERT, this.getTableName(), columns, params.toString());
    }

    protected int executeUpdate(final String query) throws HttpException {
        try (final Statement stmt = this.connection().createStatement()) {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            // Peut se produire si mysql est coupe, si la table n'existe pas/plus, ...
            throw new HttpException(e);
        }
    }

    protected abstract String getTableName();

    protected abstract List<String> getColumnNames();

    protected abstract PreparedStatement fill(PreparedStatement stmt, T e) throws SQLException;

    protected abstract T fill(ResultSet rs) throws SQLException;
}
