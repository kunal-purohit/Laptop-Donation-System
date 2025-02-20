package com.team4.servlet;

import com.team4.dao.StudentDAO;
import com.team4.beans.Student;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import utils.ConnectionDB;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentDAO studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAO(); // Initialize DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");

            switch (action) {
                case "add":
                    addStudent(request, response);
                    break;
                case "login":
                    loginStudent(request, response);
                    break;
                case "findStudentById":
                    findStudentById(request, response);
                    break;
                case "findALL":
                    findAllStudents(request, response);
                    break;
                default:
                    findAllStudents(request, response); // Default action: show all students
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

    // Add new student
    private void addStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        Connection conn = ConnectionDB.getConnection();
        String studentId = null;
        String sqlID = "SELECT MAX(s_id) AS max_id FROM student";
        PreparedStatement pstmt = conn.prepareStatement(sqlID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String maxId = rs.getString("max_id");
            if (maxId != null) {
                int newIdNum = Integer.parseInt(maxId.substring(1)) + 1; // Increment the number part
                studentId = String.format("S%03d", newIdNum); // Format as S001, S002, etc.
            } else {
                studentId = "S001"; // If no records, start with S001
            }
        }

        String sName = request.getParameter("s_name");
        Date sDOB = java.sql.Date.valueOf(request.getParameter("s_dob"));
        String sEmail = request.getParameter("s_email");
        String sMobNo = request.getParameter("s_mob");
        String sZip = request.getParameter("s_zip");
        String sVillage = request.getParameter("s_village_town");
        String sState = request.getParameter("s_state");
        String fatherName = request.getParameter("father_name");
        String motherName = request.getParameter("mother_name");
        String familyIncome = request.getParameter("family_income");
        String fatherOccupation = request.getParameter("father_occupation");
        String motherOccupation = request.getParameter("mother_occupation");
        String fatherMobNo = request.getParameter("father_mob");
        String motherMobNo = request.getParameter("mother_mob");
        String currStudying = request.getParameter("curr_studying");
        String instituteName = request.getParameter("institute");
        String regNo = request.getParameter("reg_no");
        String sPassword = request.getParameter("s_password");

        Student student = new Student(studentId, sName, sDOB, sEmail, sMobNo, sZip, sVillage, sState, fatherName, motherName,
                familyIncome, fatherOccupation, motherOccupation, fatherMobNo, motherMobNo, currStudying, instituteName, regNo, sPassword);

        boolean success = studentDAO.addStudent(student);

        if (success) {
            request.setAttribute("smessage", "Account added successfully.");
            request.getRequestDispatcher("studentLogin.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Account already exists!");
            request.getRequestDispatcher("studentRegister.jsp").forward(request, response);
        }
    }

    private void loginStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("s_email");
        String password = request.getParameter("s_password");

        // Validate student credentials
        Student student = studentDAO.validateStudent(email, password);
        if (student != null) {
            // Set the student in the session
            HttpSession session = request.getSession();
            session.setAttribute("loggedInStudent", student);

            // Redirect to the student home page
            response.sendRedirect("studentDashboard.jsp");
        } else {
            // Invalid credentials, redirect to login page with error
            request.setAttribute("message", "Invalid login credentials!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("studentLogin.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    private void requestLaptop(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    private void findStudentById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student student = studentDAO.findStudentById(request.getParameter("s_id"));

        request.setAttribute("student", student);

        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentDetails.jsp");
        dispatcher.forward(request, response);
    }

    // Find and display all students
    private void findAllStudents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> studentsList = studentDAO.findAllStudents();

        request.setAttribute("studentsList", studentsList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Students.jsp");
        dispatcher.forward(request, response);
    }
}
