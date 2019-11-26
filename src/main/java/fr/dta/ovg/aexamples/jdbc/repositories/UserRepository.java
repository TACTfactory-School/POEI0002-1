package com.ovg.app.aexamples.jdbc.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ovg.app.aexamples.jdbc.entities.User;

@Repository
public class UserRepository extends OvgRepository<User> {

    @Override
    protected String getTableName() {
        return "sys_user";
    }

    @Override
    protected List<String> getColumnNames() {
        return Arrays.asList("username", "password");
    }

    @Override
    protected PreparedStatement fill(PreparedStatement stmt, User u) throws SQLException {
        stmt.setString(1, u.getUsername());
        stmt.setString(2, u.getPassword());

        return stmt;
    }

    @Override
    protected User fill(final ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
    }

//    public static <T extends Number> T max(T a, T b) {
//        return a.doubleValue() > b.doubleValue() ? a : b;
//    }
}
