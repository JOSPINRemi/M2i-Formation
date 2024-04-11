package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/";

    private static final String DATABASE_NAME = "tp_employee";

    private static final String FULL_URL = URL + DATABASE_NAME;

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FULL_URL, USER, PASSWORD);
    }
}
