package com.example.demoApp.Controllers;

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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/Faculty")
public class FacultyServlet extends HttpServlet {
    ConnectionProperty prop;
    String select_all_role = "Select * from public.\"Faculty\"";
    ArrayList<Faculty> faculties = new ArrayList<Faculty>();
    String userPath;

    public FacultyServlet() throws FileNotFoundException, IOException{
        prop = new ConnectionProperty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpConnBuilder builder = new EmpConnBuilder();
        try (Connection conn = builder.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select_all_role);
            if(rs != null) {
                faculties.clear();
                while (rs.next()){
                    faculties.add(new Faculty(rs.getLong("id"),
                            rs.getString("nameFaculty"),
                            rs.getString("shortNameFaculty")));
                }
                rs.close();
                request.setAttribute("faculties",faculties);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        userPath = request.getServletPath();
        if("/Faculty".equals(userPath)){
            request.getRequestDispatcher("/jspf/Faculty.jsp")
                    .forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

