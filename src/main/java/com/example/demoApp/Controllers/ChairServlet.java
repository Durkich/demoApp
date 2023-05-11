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

@WebServlet("/Chair")
public class ChairServlet extends HttpServlet {
        ConnectionProperty prop;
        String userPath;

    public ChairServlet() throws FileNotFoundException, IOException{
            prop = new ConnectionProperty();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ReadData data = new ReadData();
            ArrayList<Chair>chairs = data.FillChair();
            ArrayList<Faculty>  faculties =data.FillFaculty();
            ArrayList facultyNames = new ArrayList();
            for (Faculty r:faculties)
            {
                facultyNames.add(r.getNameFaculty());
            }
            request.setAttribute("chairs",chairs);
            request.setAttribute("facultyNames",facultyNames);

            userPath = request.getServletPath();
            if("/Chair".equals(userPath)){
                request.getRequestDispatcher("/jspf/Chair.jsp")
                        .forward(request, response);
            }
        }

        protected void doPost(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        Faculty faculty = data.findByNameFaculty(data.FillFaculty(), request.getParameter("faculty"));
        try{
          Chair chair1 = new Chair(faculty, request.getParameter("nameChair"), request.getParameter("nameShortChair"));
          chair1.insert();
        } catch (SQLException e) {
                e.printStackTrace();
            }

            doGet(request, response);
        }
    }
