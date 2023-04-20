package com.example.demoApp.Domain;

public class Chair {
    private Long id;
    private Long idFaculty;
    private String nameChair;
    private String shortNameChair;

    public Chair(Long id, Long idFaculty, String nameChair, String shortNameChair) {
        this.id = id;
        this.idFaculty = idFaculty;
        this.nameChair = nameChair;
        this.shortNameChair = shortNameChair;
    }

    public Chair(Long id, String nameChair, String shortNameChair) {
        this.id = id;
        this.nameChair = nameChair;
        this.shortNameChair = shortNameChair;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Long idFaculty) {
        this.idFaculty = idFaculty;
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

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                ", idFaculty=" + idFaculty +
                ", nameChair='" + nameChair + '\'' +
                ", shortNameChair='" + shortNameChair + '\'' +
                '}';
    }
}
