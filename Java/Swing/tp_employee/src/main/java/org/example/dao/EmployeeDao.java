package org.example.dao;

import org.example.model.Employee;
import org.example.model.Gender;
import org.example.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private Connection connection;

    public EmployeeDao() {
        try {
            connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(Employee employee) {
        String query =
                "INSERT INTO employee " +
                        "(name, gender, age, blood_group, contact_number, qualification, start_date, address, image_path) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender().name());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getBloodGroup());
            preparedStatement.setString(5, employee.getContactNumber());
            preparedStatement.setString(6, employee.getQualification());
            preparedStatement.setDate(7, employee.getStartDate());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setString(9, employee.getImagePath());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(Gender.valueOf(resultSet.getString("gender")));
                employee.setAge(resultSet.getInt("age"));
                employee.setBloodGroup(resultSet.getString("blood_group"));
                employee.setContactNumber(resultSet.getString("contact_number"));
                employee.setQualification(resultSet.getString("qualification"));
                employee.setStartDate(resultSet.getDate("start_date"));
                employee.setAddress(resultSet.getString("address"));
                employee.setImagePath(resultSet.getString("image_path"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM employee WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(Gender.valueOf(resultSet.getString("gender")));
                employee.setAge(resultSet.getInt("age"));
                employee.setBloodGroup(resultSet.getString("blood_group"));
                employee.setContactNumber(resultSet.getString("contact_number"));
                employee.setQualification(resultSet.getString("qualification"));
                employee.setStartDate(resultSet.getDate("start_date"));
                employee.setAddress(resultSet.getString("address"));
                employee.setImagePath(resultSet.getString("image_path"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        String query = "UPDATE employee " +
                "SET " +
                "name = ?, " +
                "gender = ?, " +
                "age = ?, " +
                "blood_group = ?, " +
                "contact_number = ?, " +
                "qualification = ?, " +
                "start_date = ?, " +
                "address = ?, " +
                "image_path = ? " +
                "WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender().name());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getBloodGroup());
            preparedStatement.setString(5, employee.getContactNumber());
            preparedStatement.setString(6, employee.getQualification());
            preparedStatement.setDate(7, employee.getStartDate());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setString(9, employee.getImagePath());
            preparedStatement.setInt(10, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
