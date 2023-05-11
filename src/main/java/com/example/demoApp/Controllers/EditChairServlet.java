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

@WebServlet("/EditChair")
public class EditChairServlet extends HttpServlet {
    String userPath;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        ArrayList<Chair>chairs = data.FillChair();
        Chair editChair = data.findById(chairs, Long.valueOf(request.getParameter("id")));
        ArrayList<Faculty> faculties =data.FillFaculty();
        ArrayList facultyNames = new ArrayList();
        for (Faculty r:faculties)
        {
            facultyNames.add(r.getNameFaculty());
        }
        request.setAttribute("chairs",chairs);
        request.setAttribute("facultyNames",facultyNames);
        request.setAttribute("editChair",editChair);

        userPath = request.getServletPath();
        if("/EditChair".equals(userPath)){
            request.getRequestDispatcher("/jspf/EditChair.jsp")
                    .forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        Faculty faculty = data.findByNameFaculty(data.FillFaculty(), request.getParameter("faculty"));
        Chair chair1 = new Chair(Long.valueOf(request.getParameter("id")), faculty, request.getParameter("nameChair"), request.getParameter("nameShortChair"));
        chair1.update();

        doGet(request, response);
    }
}
