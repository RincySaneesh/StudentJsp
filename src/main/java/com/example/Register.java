package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "SerialNo", nullable = false)
    private int serialno;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "RollNo", nullable = false)
    private int rollno;

    @Column(name = "Department", nullable = false)
    private String department;

    public Register() {
    }

    public Register(int serialno, String name, int rollno, String department) {
        this.serialno = serialno;
        this.name = name;
        this.rollno = rollno;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialno() {
        return serialno;
    }

    public void setSerialno(int serialno) {
        this.serialno = serialno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return rollno;
    }

    public void setRoll(int rollno) {
        this.rollno = rollno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", SerialNo='" + serialno + '\'' +
                ", Name='" + name + '\'' +
                ", RollNo='" + rollno + '\'' +
                ", Department='" + department + '\'' +
                '}';
    }

}
