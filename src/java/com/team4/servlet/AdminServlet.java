package com.team4.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class AdminServlet extends HttpServlet {

    // Hardcoded admin credentials
    private static final String ADMIN_ID = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the entered admin ID and password from the request
        String adminId = request.getParameter("id");
        String adminPassword = request.getParameter("passwd");

        // Check if the entered credentials match the hardcoded values
        if (ADMIN_ID.equals(adminId) && ADMIN_PASSWORD.equals(adminPassword)) {
            // Successful login - create a session for the admin
            HttpSession session = request.getSession();
            session.setAttribute("adminLoggedIn", true);

            // Redirect to admin dashboard or any other admin page
            response.sendRedirect("adminDashboard.jsp");
        } else {
            // Failed login - send an error message back to the login page
            request.setAttribute("errorMessage", "Invalid ID or Password. Please try again.");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
    }
}