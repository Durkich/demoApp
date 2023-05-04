package com.example.demoApp.dao;

import com.example.demoApp.Domain.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadData {

    public ResultSet getData(String TableName) throws SQLException {
        String query = "SELECT * FROM public.\"" + TableName + "\"";

        EmpConnBuilder builder = new EmpConnBuilder();
        try (Connection connection = builder.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        }
    };

    public ArrayList<Faculty> FillFaculty() {
        ArrayList<Faculty> faculties = new ArrayList<Faculty>();
        try {
            ResultSet rs = getData("Faculty");
            if (rs != null) {
                faculties.clear();
                while (rs.next()) {
                    faculties.add(new Faculty(rs.getLong("id"),
                            rs.getString("nameFaculty"),
                            rs.getString("shortNameFaculty")));
                }
                rs.close();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return faculties;

    }

    public ArrayList<Curriculum> FillCurrirulum() {
        ArrayList<Curriculum> curricula = new ArrayList<Curriculum>();
        try {
            ResultSet rs = getData("Curriculum");
            if (rs != null) {
                curricula.clear();
                while (rs.next()) {
                    curricula.add(new Curriculum(rs.getLong("id"),
                            rs.getInt("academicYear"),
                            rs.getString("speciality"),
                            rs.getString("qualification"),
                            rs.getString("formEducation"),
                            rs.getString("nameCurriculum"),
                            rs.getInt("course")));

                }
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return curricula;
    }
    public ArrayList<Chair> FillChair() {
        ArrayList<Faculty> faculties = FillFaculty();
        ArrayList<Chair> chairs = new ArrayList<Chair>();
        try {
            ResultSet rs = getData("Chair");
            if (rs != null) {
                chairs.clear();
                while (rs.next()) {
                    chairs.add(new Chair(rs.getLong("id"),
                            findById(faculties, rs.getLong("idFaculty")),
                            rs.getString("nameChair"),
                            rs.getString("shortNameChair")));
                }
                rs.close();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return chairs;
    }
    public ArrayList<Discipline> FillDiscipline(){
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            ResultSet rs = getData("Discipline");
            if(rs != null) {
                disciplines.clear();
                while (rs.next()){
                    disciplines.add(new Discipline(rs.getLong("id"),
                            rs.getString("nameDiscipline"),
                            rs.getInt("course"),
                            rs.getInt("semester"),
                            rs.getInt("lecture"),
                            rs.getInt("labratory"),
                            rs.getInt("practical"),
                            Discipline.DisciplineType.valueOf(rs.getString("disciplineType")),
                           findById(FillChair(), rs.getLong("idChair")),
                            findById(FillCurrirulum(), rs.getLong("idCurriculum"))));
                }
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return disciplines;
    }
    public <T extends IFinder> T findById(ArrayList<T> list, Long id) {
        for (T item : list) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}

