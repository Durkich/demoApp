package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Curriculum;
import com.example.demoApp.Domain.Discipline;
import com.example.demoApp.dao.ConnectionProperty;
import com.example.demoApp.dao.EmpConnBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/Discipline")
public class DisciplineServlet extends HttpServlet {

    ConnectionProperty prop;
    String select_all_role = "Select * from public.\"Discipline\"";
    ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
    String userPath;

    public DisciplineServlet() throws FileNotFoundException, IOException{
        prop = new ConnectionProperty();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpConnBuilder builder = new EmpConnBuilder();
        try (Connection conn = builder.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select_all_role);
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
                            Discipline.DisciplineType.valueOf(rs.getString("disciplineType"))));

                }
                rs.close();
                request.setAttribute("disciplines",disciplines);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        userPath = request.getServletPath();
        if("/Discipline".equals(userPath)){
            request.getRequestDispatcher("/jspf/Discipline.jsp")
                    .forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}