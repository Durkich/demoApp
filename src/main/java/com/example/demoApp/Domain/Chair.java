package com.example.demoApp.Domain;

import com.example.demoApp.dao.EmpConnBuilder;
import com.example.demoApp.dao.ReadData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public Chair(Faculty faculty, String nameChair, String shortNameChair) throws SQLException {
        ReadData data = new ReadData();
        this.id = data.generateId("Chair");
        this.faculty = faculty;
        this.nameChair = nameChair;
        this.shortNameChair = shortNameChair;
    }
    public boolean update(){
        String insertChair = "UPDATE public.\"Chair\" SET \"idFaculty\"=?, \"nameChair\"=?, \"shortNameChair\"=? where id = ?";
        EmpConnBuilder builder = new EmpConnBuilder();
        try {
            Connection connection = builder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertChair);
            preparedStatement.setLong(1, this.faculty.getId());
            preparedStatement.setString(2, this.nameChair);
            preparedStatement.setString(3, this.shortNameChair);
            preparedStatement.setLong(4, this.id);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean insert(){
        String insertChair = "INSERT INTO public.\"Chair\" VALUES (?, ?, ?,?)";
        EmpConnBuilder builder = new EmpConnBuilder();
        try {
            Connection connection = builder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertChair);
            preparedStatement.setLong(1, this.id);
            preparedStatement.setLong(2, this.faculty.getId());
            preparedStatement.setString(3, this.nameChair);
            preparedStatement.setString(4, this.shortNameChair);
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
