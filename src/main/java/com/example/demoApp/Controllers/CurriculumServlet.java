package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Curriculum;
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


@WebServlet("/Curriculum")
public class CurriculumServlet extends HttpServlet {

    ConnectionProperty prop;
    String userPath;

    public CurriculumServlet() throws FileNotFoundException, IOException{
        prop = new ConnectionProperty();
    }
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ReadData data = new ReadData();
        ArrayList<Curriculum> curricula = data.FillCurrirulum();
            request.setAttribute("curricula",curricula);
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