package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Discipline;
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

@WebServlet("/Discipline")
public class DisciplineServlet extends HttpServlet {

    ConnectionProperty prop;
    String userPath;

    public DisciplineServlet() throws FileNotFoundException, IOException{
        prop = new ConnectionProperty();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ReadData data = new ReadData();
      ArrayList<Discipline>disciplines = data.FillDiscipline();
      ArrayList chairNames = new ArrayList();
      ArrayList curriculumNames = new ArrayList();
        for (Discipline r:disciplines)
        {
            chairNames.add(r.getNameChair());
            curriculumNames.add(r.getNameCurriculum());
        }
        request.setAttribute("disciplines",disciplines);
        request.setAttribute("disciplinesType",Discipline.DisciplineType.values());
        request.setAttribute("chairNames",chairNames);
        request.setAttribute("curriculumNames",curriculumNames);

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