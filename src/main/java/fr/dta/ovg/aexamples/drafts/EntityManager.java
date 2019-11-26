package com.ovg.app.aexamples.drafts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class EntityManager {

    private Connection connection;

    public EntityManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // TODO: Use application.properties file.
        final String url = "jdbc:mysql://localhost:8889/ovg_event";
        final String utilisateur = "joe";
        final String motDePasse = "root";

        try {
            this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        if (!this.connection.isClosed()) {
            this.connection.close();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
