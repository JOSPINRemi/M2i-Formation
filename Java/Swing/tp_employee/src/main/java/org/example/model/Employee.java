package org.example.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Employee {

    private int id;

    private String name;

    private Gender gender;

    private int age;

    private String bloodGroup;

    private String contactNumber;

    private String qualification;

    private Date startDate;

    private String address;

    private String imagePath;
}
