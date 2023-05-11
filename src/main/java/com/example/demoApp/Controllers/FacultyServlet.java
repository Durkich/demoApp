package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Chair;
import com.example.demoApp.Domain.Faculty;
import com.example.demoApp.dao.ConnectionProperty;
import com.example.demoApp.dao.ReadData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Faculty")
public class FacultyServlet extends HttpServlet {
    ConnectionProperty prop;
    String userPath;
    public FacultyServlet() throws FileNotFoundException, IOException{
        prop = new ConnectionProperty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        ArrayList<Faculty> faculties = data.FillFaculty();
        request.setAttribute("faculties",faculties);
        userPath = request.getServletPath();
        if("/Faculty".equals(userPath)){
            request.getRequestDispatcher("/jspf/Faculty.jsp")
                    .forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        try{
            Faculty faculty = new Faculty( request.getParameter("nameFaculty"), request.getParameter("nameShortFaculty"));
            faculty.insert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }
}

