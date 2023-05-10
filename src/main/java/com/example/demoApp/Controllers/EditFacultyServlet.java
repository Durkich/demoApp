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

@WebServlet(name = "EditFaculty", value = "/EditFaculty")
public class EditFacultyServlet extends HttpServlet {
    ConnectionProperty prop;
    String userPath;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        ArrayList<Faculty> faculties = data.FillFaculty();
        Faculty editFaculty = data.findById(faculties,Long.valueOf(request.getParameter("id")));
        request.setAttribute("editFaculty",editFaculty);
        request.setAttribute("faculties", faculties);
        userPath = request.getServletPath();
        if ("/EditFaculty".equals(userPath)) {
            request.getRequestDispatcher("/jspf/EditFaculty.jsp")
                    .forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Faculty faculty = new Faculty(Long.valueOf(request.getParameter("id")), request.getParameter("nameFaculty"), request.getParameter("nameShortFaculty"));
        faculty.update();
        response.sendRedirect("/Faculty");
    }
}