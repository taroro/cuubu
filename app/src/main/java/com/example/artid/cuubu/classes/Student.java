package com.example.artid.cuubu.classes;

import java.util.ArrayList;

public class Student {
    private String email;
    private String firstname;
    private String lastname;
    private ArrayList<Subject> registeredSubjects;

    public Student() { }

    public Student(String email, String firstname, String lastname,
                   ArrayList<Subject> registeredSubjects) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.registeredSubjects = registeredSubjects;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public ArrayList<Subject> getRegisteredSubjects() { return registeredSubjects; }

    public void setRegisteredSubjects(ArrayList<Subject> registeredSubjects) {
        this.registeredSubjects = registeredSubjects;
    }
}
