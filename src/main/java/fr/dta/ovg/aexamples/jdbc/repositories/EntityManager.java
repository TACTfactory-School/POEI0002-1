package com.ovg.app.aexamples.jdbc.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class EntityManager {

    private Connection connection;

    public EntityManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // TODO: Use application.properties file.
        final String url = "jdbc:mysql://localhost:3306/ovg";
        final String utilisateur = "dev";
        final String motDePasse = "dev";

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
