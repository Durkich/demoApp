package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Chair;
import com.example.demoApp.Domain.Curriculum;
import com.example.demoApp.Domain.Discipline;
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
      ArrayList<Chair> chairs = data.FillChair();
      ArrayList<Curriculum> curriculum = data.FillCurrirulum();
      ArrayList chairNames = new ArrayList();
      ArrayList curriculumNames = new ArrayList();
        for (Chair r:chairs)
        {
            chairNames.add(r.getNameChair());

        }
        for (Curriculum r:curriculum)
        {
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
        ReadData data = new ReadData();
        Chair chair = data.findByNameChair(data.FillChair(), request.getParameter("chairName"));
        Curriculum curriculum = data.findByNameCurriculum(data.FillCurrirulum(),request.getParameter("curriculumName"));
        try{
            Discipline discipline = new Discipline(request.getParameter("NameDiscipline"),
                    Integer.parseInt(request.getParameter("Course")),
                    Integer.parseInt(request.getParameter("Semester")),
                    Integer.parseInt(request.getParameter("Lecture")),
                    Integer.parseInt(request.getParameter("Laboratory")),
                    Integer.parseInt(request.getParameter("Practical")),
                    Discipline.DisciplineType.valueOf(request.getParameter("disciplinesType")),
                    chair,
                    curriculum
                    );
            discipline.insert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }
}