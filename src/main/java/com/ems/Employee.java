package com.ems;

public class Employee {

    private String id;
    private String name;
    private String fatherName;
    private String email;
    private String position;
    private String contact;
    private String salary;

    public Employee(
            String id,
            String name,
            String fatherName,
            String email,
            String position,
            String contact,
            String salary)
    {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.email = email;
        this.position = position;
        this.contact = contact;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getContact() {
        return contact;
    }

    public String getSalary() {
        return salary;
    }
}