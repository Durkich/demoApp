package com.example.demoApp.Controllers;

import com.example.demoApp.Domain.Chair;
import com.example.demoApp.Domain.Faculty;
import com.example.demoApp.dao.ConnectionProperty;
import com.example.demoApp.dao.EmpConnBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/Chair")
public class ChairServlet extends HttpServlet {
        ConnectionProperty prop;
        String select_all_role = "Select * from public.\"Chair\"";
        ArrayList<Chair> chairs = new ArrayList<Chair>();
        String userPath;

    public ChairServlet() throws FileNotFoundException, IOException{
            prop = new ConnectionProperty();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EmpConnBuilder builder = new EmpConnBuilder();
            try (Connection conn = builder.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(select_all_role);
                if(rs != null) {
                    chairs.clear();
                    while (rs.next()){
                        chairs.add(new Chair(rs.getLong("id"),
                                rs.getString("nameChair"),
                                rs.getString("shortNameChair")));
                    }
                    rs.close();
                    request.setAttribute("chairs",chairs);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            userPath = request.getServletPath();
            if("/Chair".equals(userPath)){
                request.getRequestDispatcher("/jspf/Chair.jsp")
                        .forward(request, response);
            }
        }
        protected void doPost(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }
    }
