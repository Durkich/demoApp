package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Curriculum;
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


@WebServlet("/EditCurriculum")
public class EditCurriculumServlet extends HttpServlet {

    String userPath;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadData data = new ReadData();
        ArrayList<Curriculum> curricula = data.FillCurrirulum();
        Curriculum editCurriculum = data.findById(curricula, Long.valueOf(request.getParameter("id")));
        request.setAttribute("editCurriculum", editCurriculum);
        request.setAttribute("curricula",curricula);
        userPath = request.getServletPath();
        if("/EditCurriculum".equals(userPath)){
            request.getRequestDispatcher("/jspf/EditCurriculum.jsp")
                    .forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Curriculum curriculum = new Curriculum(Long.valueOf(request.getParameter("id")), Integer.parseInt(request.getParameter("academicYear")),
                request.getParameter("Speciality"),
                request.getParameter("Quialification"),
                request.getParameter("formEducation"),
                request.getParameter("NameCircullum"),
                Integer.parseInt(request.getParameter("Course"))
        );
        curriculum.update();
        response.sendRedirect("/Discipline");
    }
}