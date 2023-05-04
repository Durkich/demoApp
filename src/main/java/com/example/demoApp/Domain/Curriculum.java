package com.example.demoApp.Domain;


public class Curriculum implements IFinder {
    private Long id;
    private int academicYear;
    private String speciality;
    private String qualification;
    private String formEducation;
    private String nameCurriculum;
    private int course;

    public Curriculum(Long id,
                      int academicYear,
                      String speciality,
                      String qualification,
                      String formEducation,
                      String nameCurriculum,
                      int course) {
        this.id = id;
        this.academicYear = academicYear;
        this.speciality = speciality;
        this.qualification = qualification;
        this.formEducation = formEducation;
        this.nameCurriculum = nameCurriculum;
        this.course = course;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getFormEducation() {
        return formEducation;
    }

    public void setFormEducation(String formEducation) {
        this.formEducation = formEducation;
    }

    public String getNameCurriculum() {
        return nameCurriculum;
    }

    public void setNameCurriculum(String nameCurriculum) {
        this.nameCurriculum = nameCurriculum;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
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
                ", quialification='" + qualification + '\'' +
                ", formEducation='" + formEducation + '\'' +
                ", nameCircullum='" + nameCurriculum + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}