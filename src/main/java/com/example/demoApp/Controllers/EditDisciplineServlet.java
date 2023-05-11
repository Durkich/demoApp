package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Chair;
import com.example.demoApp.Domain.Curriculum;
import com.example.demoApp.Domain.Discipline;
import com.example.demoApp.dao.ReadData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/EditDiscipline")
public class EditDisciplineServlet extends HttpServlet {
    String userPath;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        ArrayList<Discipline> disciplines = data.FillDiscipline();
        Discipline editDiscipline = data.findById(disciplines, Long.valueOf(request.getParameter("id")));
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
        request.setAttribute("editDiscipline",editDiscipline);
        request.setAttribute("disciplines",disciplines);
        request.setAttribute("disciplinesType",Discipline.DisciplineType.values());
        request.setAttribute("chairNames",chairNames);
        request.setAttribute("curriculumNames",curriculumNames);

        userPath = request.getServletPath();
        if("/EditDiscipline".equals(userPath)){
            request.getRequestDispatcher("/jspf/EditDiscipline.jsp")
                    .forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        Chair chair = data.findByNameChair(data.FillChair(), request.getParameter("chairName"));
        Curriculum curriculum = data.findByNameCurriculum(data.FillCurrirulum(),request.getParameter("curriculumName"));
        Discipline discipline = new Discipline(Long.valueOf(request.getParameter("id")),
                request.getParameter("NameDiscipline"),
                Integer.parseInt(request.getParameter("Course")),
                Integer.parseInt(request.getParameter("Semester")),
                Integer.parseInt(request.getParameter("Lecture")),
                Integer.parseInt(request.getParameter("Laboratory")),
                Integer.parseInt(request.getParameter("Practical")),
                Discipline.DisciplineType.valueOf(request.getParameter("disciplinesType")),
                chair,
                curriculum
        );
        discipline.update();
        response.sendRedirect("/Discipline");
    }
}