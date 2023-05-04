package com.example.demoApp.Controllers;

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
import java.util.ArrayList;

@WebServlet("/Faculty")
public class FacultyServlet extends HttpServlet {
    ConnectionProperty prop;
    String userPath;
    String name = "Faculty";

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
        doGet(request, response);
    }
}

