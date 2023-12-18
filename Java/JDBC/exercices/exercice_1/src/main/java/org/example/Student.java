package org.example;

import java.sql.*;

public class Student {
    public static Connection connection;
    private static String TABLE_NAME = "student";
    private static String col1 = "last_name";
    private static String col2 = "first_name";
    private static String col3 = "class_number";
    private static String col4 = "degree_date";
    private static String query;


    public static int addStudent(String lastName, String firstName, int classNumber, Date degreeDate) throws SQLException {
        query =
                "INSERT INTO " + TABLE_NAME +
                        "(" + col1 + ", " + col2 + ", " + col3 + ", " + col4 + ")" +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setInt(3, classNumber);
        preparedStatement.setDate(4, degreeDate);
        return preparedStatement.executeUpdate();
    }

    public static ResultSet showStudents() throws SQLException {
        query = "SELECT * FROM " + TABLE_NAME;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public static void showStudentsFromClass(int classNumber) {
    }

    public static void deleteStudent(int id) {
    }
}
