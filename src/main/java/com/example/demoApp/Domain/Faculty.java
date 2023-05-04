package com.example.demoApp.Domain;

import com.example.demoApp.dao.EmpConnBuilder;
import com.example.demoApp.dao.ReadData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Faculty implements IFinder {
    private Long id;
    private String NameFaculty;
    private String ShortNameFaculty;

    public Faculty(Long id, String nameFaculty, String shortNameFaculty) {
        this.id = id;
        NameFaculty = nameFaculty;
        ShortNameFaculty = shortNameFaculty;
    }

    public Faculty(String nameFaculty, String shortNameFaculty)throws SQLException {
        ReadData data = new ReadData();
        this.id = data.generateId("Faculty")+1;
        NameFaculty = nameFaculty;
        ShortNameFaculty = shortNameFaculty;
    }
    public boolean insert(){
        String insertFaculty = "INSERT INTO public.\"Faculty\" VALUES (?, ?, ?)";
        EmpConnBuilder builder = new EmpConnBuilder();
        try {
            Connection connection = builder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertFaculty);
            preparedStatement.setLong(1, this.id);
            preparedStatement.setString(2, this.NameFaculty);
            preparedStatement.setString(3, this.ShortNameFaculty);
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
