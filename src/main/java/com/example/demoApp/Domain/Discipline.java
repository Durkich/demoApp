package com.example.demoApp.Domain;

public class Discipline {
    private Long id;
    private Long idChair;
    private Long idCirriculum;
    private String nameDiscipline;
    private int course;
    private int semester;
    private int lecture;
    private int laboratory;
    private int practical;

    public Discipline(Long id, Long idChair, Long idCirriculum, String nameDiscipline, int course, int semester, int lecture, int laboratory, int practical) {
        this.id = id;
        this.idChair = idChair;
        this.idCirriculum = idCirriculum;
        this.nameDiscipline = nameDiscipline;
        this.course = course;
        this.semester = semester;
        this.lecture = lecture;
        this.laboratory = laboratory;
        this.practical = practical;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdChair() {
        return idChair;
    }

    public void setIdChair(Long idChair) {
        this.idChair = idChair;
    }

    public Long getIdCirriculum() {
        return idCirriculum;
    }

    public void setIdCirriculum(Long idCirriculum) {
        this.idCirriculum = idCirriculum;
    }

    public String getNameDiscipline() {
        return nameDiscipline;
    }

    public void setNameDiscipline(String nameDiscipline) {
        this.nameDiscipline = nameDiscipline;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getLecture() {
        return lecture;
    }

    public void setLecture(int lecture) {
        this.lecture = lecture;
    }

    public int getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(int laboratory) {
        this.laboratory = laboratory;
    }

    public int getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", idChair=" + idChair +
                ", idCirriculum=" + idCirriculum +
                ", nameDiscipline='" + nameDiscipline + '\'' +
                ", course=" + course +
                ", semester=" + semester +
                ", lecture=" + lecture +
                ", laboratory=" + laboratory +
                ", practical=" + practical +
                '}';
    }

    enum asessmentType{
        EXAM,
        SETOFF
    }

}
