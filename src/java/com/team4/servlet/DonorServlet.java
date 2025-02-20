package com.team4.servlet;

import com.team4.dao.DonorDAO;
import com.team4.beans.Donor;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import utils.ConnectionDB;
import java.sql.*;

@WebServlet("/donor")
public class DonorServlet extends HttpServlet {

    private DonorDAO donorDAO;

    @Override
    public void init() {
        donorDAO = new DonorDAO(); // Initialize DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            
            switch (action) {
                case "add":
                    addDonor(request, response);
                    break;
                case "login":
                    loginDonor(request, response);
                    break;
                case "findDonorById":
                    findDonorById(request, response);
                    break;
                case "findALL":
                    findAllDonors(request, response);
                    break;
                default:
                    findAllDonors(request, response); // Default action: show all donors
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Handle GET requests the same as POST
    }

    // Add new donor
    private void addDonor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        Connection conn = ConnectionDB.getConnection();
        String did = null;
        String sqlID = "SELECT MAX(d_id) AS max_id FROM donor";
        PreparedStatement pstmt = conn.prepareStatement(sqlID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String maxId = rs.getString("max_id");
            if (maxId != null) {
                int newIdNum = Integer.parseInt(maxId.substring(1)) + 1; // Increment the number part
                did = String.format("D%03d", newIdNum); // Format as D001, D002, etc.
            } else {
            did = "D001"; // If no records, start with D001
            }
        }

        String dname = request.getParameter("d_name");
        String email = request.getParameter("d_email");
        String mobile = request.getParameter("d_mob");
        String town = request.getParameter("d_town_city");
        String state = request.getParameter("d_state");
        String zip = request.getParameter("d_zip");
        String password = request.getParameter("d_password");

        Donor donor = new Donor(did, dname, email, mobile, town, state, zip, password);
        
        boolean success = donorDAO.addDonor(donor);

        if (success) {
            request.setAttribute("smessage", "Account added successfully.");
            request.getRequestDispatcher("donorLogin.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Account already exists!");
            request.getRequestDispatcher("donorRegister.jsp").forward(request, response);
        }

    }

    private void loginDonor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("d_email");
        String password = request.getParameter("d_password");

        // Validate donor credentials
        Donor donor = donorDAO.validateDonor(email, password);
        if (donor != null) {
            // Set the donor in the session
            HttpSession session = request.getSession();
            session.setAttribute("loggedInDonor", donor);

            response.sendRedirect("donorDashboard.jsp");
        } else {
            // Invalid credentials, redirect to login page with error
            request.setAttribute("message", "Invalid login credentials!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donorLogin.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    private void findDonorById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Donor donor = donorDAO.findDonorById(request.getParameter("d_id"));

        request.setAttribute("donorsList", donor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Donors.jsp");
        dispatcher.forward(request, response);
    }

    // Find and display all donors
    private void findAllDonors(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Donor> donorsList = donorDAO.findAllDonors();

        request.setAttribute("donorsList", donorsList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Donors.jsp");
        dispatcher.forward(request, response);
    }
}