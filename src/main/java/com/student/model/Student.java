package com.student.model;

public class Student {

    private String studentNumder;
    private String firstname;
    private String surname;
    private Long demerits;

    public Student(String studentNumder, String firstname, String surname, Long demerits) {
        this.studentNumder = studentNumder;
        this.firstname = firstname;
        this.surname = surname;
        this.demerits = demerits;
    }

    public String getStudentNumder() {
        return studentNumder;
    }

    public void setStudentNumder(String studentNumder) {
        this.studentNumder = studentNumder;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getDemerits() {
        return demerits;
    }

    public void setDemerits(Long demerits) {
        this.demerits = demerits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumder='" + studentNumder + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", demerits=" + demerits +
                '}';
    }
}
