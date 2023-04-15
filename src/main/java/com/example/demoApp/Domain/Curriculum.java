package com.example.demoApp.Domain;

import java.util.Date;

public class Curriculum {
    private Long id;
    private Date academicYear;
    private String speciality;
    private String quialification;
    private String formEducation;
    private String nameCircullum;
    private String course;

    public Curriculum(Long id,
                      Date academicYear,
                      String speciality,
                      String quialification,
                      String formEducation,
                      String nameCircullum,
                      String course) {
        this.id = id;
        this.academicYear = academicYear;
        this.speciality = speciality;
        this.quialification = quialification;
        this.formEducation = formEducation;
        this.nameCircullum = nameCircullum;
        this.course = course;
    }

    public Date getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Date academicYear) {
        this.academicYear = academicYear;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQuialification() {
        return quialification;
    }

    public void setQuialification(String quialification) {
        this.quialification = quialification;
    }

    public String getFormEducation() {
        return formEducation;
    }

    public void setFormEducation(String formEducation) {
        this.formEducation = formEducation;
    }

    public String getNameCircullum() {
        return nameCircullum;
    }

    public void setNameCircullum(String nameCircullum) {
        this.nameCircullum = nameCircullum;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", academicYear=" + academicYear +
                ", speciality='" + speciality + '\'' +
                ", quialification='" + quialification + '\'' +
                ", formEducation='" + formEducation + '\'' +
                ", nameCircullum='" + nameCircullum + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}