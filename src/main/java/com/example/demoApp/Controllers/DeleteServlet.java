package com.example.demoApp.Controllers;

import com.example.demoApp.dao.ReadData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "delete", value = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadData dataDeleter = new ReadData();
        try {
            dataDeleter.deleteData(request.getParameter("tableName"), Long.valueOf(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getParameter("redirectPage"));
    }
}


