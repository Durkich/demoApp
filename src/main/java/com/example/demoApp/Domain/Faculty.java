package com.example.demoApp.Domain;

public class Faculty implements IFinder {
    private Long id;
    private String NameFaculty;
    private String ShortNameFaculty;

    public Faculty(Long id, String nameFaculty, String shortNameFaculty) {
        this.id = id;
        NameFaculty = nameFaculty;
        ShortNameFaculty = shortNameFaculty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFaculty() {
        return NameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        NameFaculty = nameFaculty;
    }

    public String getShortNameFaculty() {
        return ShortNameFaculty;
    }

    public void setShortNameFaculty(String shortNameFaculty) {
        ShortNameFaculty = shortNameFaculty;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", NameFaculty='" + NameFaculty + '\'' +
                ", ShortNameFaculty='" + ShortNameFaculty + '\'' +
                '}';
    }
}
