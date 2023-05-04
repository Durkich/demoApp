package com.example.demoApp.Domain;

public class Discipline implements IFinder {


    private Long id;
    private String nameDiscipline;
    private int course;
    private int semester;
    private int lecture;
    private int laboratory;
    private int practical;
    private DisciplineType disciplineType;
    private Chair chair;
    private Curriculum curriculum;

    public Discipline(Long id, String nameDiscipline, int course, int semester, int lecture, int laboratory, int practical, DisciplineType disciplineType, Chair chair, Curriculum curriculum) {
        this.id = id;
        this.nameDiscipline = nameDiscipline;
        this.course = course;
        this.semester = semester;
        this.lecture = lecture;
        this.laboratory = laboratory;
        this.practical = practical;
        this.disciplineType = disciplineType;
        this.chair = chair;
        this.curriculum = curriculum;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
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

    public DisciplineType getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(DisciplineType disciplineType) {
        this.disciplineType = disciplineType;
    }

    public String getNameChair(){return chair.getNameChair();}
    public String getNameCurriculum(){return curriculum.getNameCurriculum();}

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", chair=" + chair +
                ", curriculum=" + curriculum +
                ", nameDiscipline='" + nameDiscipline + '\'' +
                ", course=" + course +
                ", semester=" + semester +
                ", lecture=" + lecture +
                ", laboratory=" + laboratory +
                ", practical=" + practical +
                ", disciplineType=" + disciplineType +
                '}';
    }


    public enum DisciplineType {
        Экзамен,
        Зачет,
    }
    }


