package com.example.demoApp.Domain;

public class Chair implements IFinder {
    private Long id;
    private Faculty faculty;
    private String nameChair;
    private String shortNameChair;



    public Chair(Long id, String nameChair, String shortNameChair) {
        this.id = id;
        this.nameChair = nameChair;
        this.shortNameChair = shortNameChair;
    }

    public Chair(Long id, Faculty faculty, String nameChair, String shortNameChair) {
        this.id = id;
        this.faculty = faculty;
        this.nameChair = nameChair;
        this.shortNameChair = shortNameChair;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNameChair() {
        return nameChair;
    }

    public void setNameChair(String nameChair) {
        this.nameChair = nameChair;
    }

    public String getShortNameChair() {
        return shortNameChair;
    }

    public void setShortNameChair(String shortNameChair) {
        this.shortNameChair = shortNameChair;
    }


    public Faculty getFaculty() {
        return faculty;
    }

    public String getFacultyName(){return faculty.getNameFaculty();}

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", nameChair='" + nameChair + '\'' +
                ", shortNameChair='" + shortNameChair + '\'' +
                '}';
    }
}
