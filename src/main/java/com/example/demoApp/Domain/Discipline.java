package com.example.demoApp.Domain;

import com.example.demoApp.dao.EmpConnBuilder;
import com.example.demoApp.dao.ReadData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public Discipline(String nameDiscipline, int course, int semester, int lecture, int laboratory, int practical, DisciplineType disciplineType, Chair chair, Curriculum curriculum) throws SQLException {
        ReadData data = new ReadData();
        this.id = data.generateId("Discipline");
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
    public boolean update(){
        String insertFaculty = "UPDATE public.\"Discipline\" SET \"idChair\"=?, \"idCurriculum\"=?, \"nameDiscipline\"=?, course=?, semester=?, lecture=?, labratory=?, practical=?, \"disciplineType\"=? where id = ?";
        EmpConnBuilder builder = new EmpConnBuilder();
        try {
            Connection connection = builder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertFaculty);
            preparedStatement.setLong(1,this.chair.getId());
            preparedStatement.setLong(2,this.curriculum.getId());
            preparedStatement.setString(3, this.nameDiscipline);
            preparedStatement.setInt(4, this.course);
            preparedStatement.setInt(5, this.semester);
            preparedStatement.setInt(6, this.lecture);
            preparedStatement.setInt(7, this.laboratory);
            preparedStatement.setInt(8, this.practical);
            preparedStatement.setString(9, String.valueOf(this.disciplineType));
            preparedStatement.setLong(10, this.id);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean insert(){
        String insertFaculty = "INSERT INTO public.\"Discipline\" VALUES (?, ?, ?,?,?,?,?,?,?,?)";
        EmpConnBuilder builder = new EmpConnBuilder();
        try {
            Connection connection = builder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertFaculty);
            preparedStatement.setLong(1, this.id);
            preparedStatement.setLong(2,this.chair.getId());
            preparedStatement.setLong(3,this.curriculum.getId());
            preparedStatement.setString(4, this.nameDiscipline);
            preparedStatement.setInt(5, this.course);
            preparedStatement.setInt(6, this.semester);
            preparedStatement.setInt(7, this.lecture);
            preparedStatement.setInt(8, this.laboratory);
            preparedStatement.setInt(9, this.practical);
            preparedStatement.setString(10, String.valueOf(this.disciplineType));
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
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


