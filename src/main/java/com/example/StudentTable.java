package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
class StudentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "roll_number")
    private String rollNumber;

    @Column(name = "department")
    private String department;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCourse() {
        return department;
    }

    public void setCourse(String course) {
        this.department = course;
    }
}
