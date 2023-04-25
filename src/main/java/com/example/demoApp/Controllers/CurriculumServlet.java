package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Curriculum;
import com.example.demoApp.Domain.Faculty;
import com.example.demoApp.dao.ConnectionProperty;
import com.example.demoApp.dao.EmpConnBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


@WebServlet("/Curriculum")
public class CurriculumServlet extends HttpServlet {

    ConnectionProperty prop;
    String select_all_role = "Select * from public.\"Curriculum\"";
    ArrayList<Curriculum> curricula = new ArrayList<Curriculum>();
    String userPath;

    public CurriculumServlet() throws FileNotFoundException, IOException{
        prop = new ConnectionProperty();
    }
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EmpConnBuilder builder = new EmpConnBuilder();
            try (Connection conn = builder.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(select_all_role);
                if(rs != null) {
                    curricula.clear();
                    while (rs.next()){
                        curricula.add(new Curriculum(rs.getLong("id"),
                                rs.getInt("academicYear"),
                                rs.getString("speciality"),
                                rs.getString("qualification"),
                                rs.getString("formEducation"),
                                rs.getString("nameCurriculum"),
                                rs.getInt("course")));

                    }
                    rs.close();
                    request.setAttribute("curricula",curricula);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            userPath = request.getServletPath();
            if("/Curriculum".equals(userPath)){
                request.getRequestDispatcher("/jspf/Curriculum.jsp")
                        .forward(request, response);
            }
        }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    }