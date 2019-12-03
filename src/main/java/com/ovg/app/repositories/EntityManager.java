package com.ovg.app.repositories;

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
        final String url = "jdbc:mysql://localhost:3306/ovg?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String utilisateur = "root";
        final String motDePasse = "";

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
