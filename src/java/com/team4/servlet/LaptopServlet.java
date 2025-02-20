package com.team4.servlet;

import com.team4.beans.Laptop;
import com.team4.beans.Requests;
import com.team4.dao.LaptopDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.http.HttpSession;
import utils.ConnectionDB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/laptop")
public class LaptopServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String action = request.getParameter("action"); // Get the action from the form

            if ("add".equalsIgnoreCase(action)) {
                Connection conn = ConnectionDB.getConnection();
                String lapId = null;
                String sqlID = "SELECT MAX(lap_id) AS max_id FROM laptop";
                PreparedStatement pstmt = conn.prepareStatement(sqlID);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String maxId = rs.getString("max_id");
                    if (maxId != null) {
                        int newIdNum = Integer.parseInt(maxId.substring(1)) + 1; // Increment the number part
                        lapId = String.format("L%03d", newIdNum); // Format as S001, S002, etc.
                    } else {
                        lapId = "L001"; // If no records, start with S001
                    }
                }

                HttpSession session = request.getSession();
                String dId = (String) session.getAttribute("d_id");

                Laptop laptop = new Laptop();
                laptop.setlapId(lapId);
                laptop.setBrand(request.getParameter("brand"));
                laptop.setProcessor(request.getParameter("processor"));
                laptop.setRam(request.getParameter("ram"));
                laptop.setStorage(request.getParameter("storage"));
                laptop.setNoOfDevices(Integer.parseInt(request.getParameter("no_of_devices")));
                laptop.setdId(request.getParameter("did"));

                boolean isInserted = false;
                isInserted = LaptopDAO.insertLaptop(laptop);

                if (isInserted) {
                    request.setAttribute("message", "Laptop added for donation.");
                    request.getRequestDispatcher("donorDashboard.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Failed to add laptop!");
                    request.getRequestDispatcher("addLaptop.jsp").forward(request, response);
                }

            } else if ("approve".equalsIgnoreCase(action)) {
        String reqId = request.getParameter("reqId"); // Get the request ID from the form
        Connection conn = ConnectionDB.getConnection();

        // Update the request status to "Approved"
        String updateRequestStatus = "UPDATE request SET req_status = ? WHERE req_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateRequestStatus)) {
            pstmt.setString(1, "Approved");
            pstmt.setString(2, reqId);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Get the laptop ID from the request using the request ID
                String laptopIdQuery = "SELECT lap_id FROM request WHERE req_id = ?";
                String laptopId = null;

                try (PreparedStatement laptopStmt = conn.prepareStatement(laptopIdQuery)) {
                    laptopStmt.setString(1, reqId);
                    ResultSet rs = laptopStmt.executeQuery();
                    if (rs.next()) {
                        laptopId = rs.getString("lapId");
                    }
                }

                // Decrease the stock of the laptop
                String updateLaptopStock = "UPDATE laptop SET no_of_devices = no_of_devices - 1 WHERE lap_id = ?";
                try (PreparedStatement laptopUpdateStmt = conn.prepareStatement(updateLaptopStock)) {
                    laptopUpdateStmt.setString(1, laptopId);
                    laptopUpdateStmt.executeUpdate();
                }

                // Set a success message
                request.setAttribute("message", "Request approved successfully!");
            } else {
                request.setAttribute("errorMessage", "Failed to approve request. Please try again.");
            }
    } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("errorMessage", "An error occurred while approving the request.");
    }
    
   

            } else if ("req".equalsIgnoreCase(action)) {

                Requests requests = new Requests();

                String studentId = request.getParameter("s_id");

                Connection conn = ConnectionDB.getConnection();
                String reqId = null;
                String sqlID = "SELECT MAX(req_id) AS max_id FROM request";
                PreparedStatement pstmt = conn.prepareStatement(sqlID);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String maxId = rs.getString("max_id");
                    if (maxId != null) {
                        int newIdNum = Integer.parseInt(maxId.substring(1)) + 1; // Increment the number part
                        reqId = String.format("R%03d", newIdNum); // Format as S001, S002, etc.
                    } else {
                        reqId = "R001"; // If no records, start with S001
                    }
                }

                // Get the selected laptop ID from the form submission
                String laptopId = request.getParameter("lap_id");
                // Get the current date for the request
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String requestDate = sdf.format(now);

                // Prepare the SQL query to insert the request
                PreparedStatement ps = conn.prepareStatement("INSERT INTO request(req_id, s_id, lap_id, req_date, req_status) VALUES (?, ?, ?, ?, ?)");

                ps.setString(1, reqId);  // Requests ID
                ps.setString(2, studentId);     // Student ID from session
                ps.setString(3, laptopId);      // Laptop ID from form
                ps.setString(4, requestDate);   // Requests date
                ps.setString(5, "Pending");     // Requests status

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    // Redirect to the success page if the insertion is successful
                    request.getRequestDispatcher("studentViewOrders.jsp").forward(request, response);
                } else {
                    // Redirect to an error page if something goes wrong
                    request.setAttribute("errorMessage", "Failed to request laptop. Please try again.");
                    request.getRequestDispatcher("requestLaptop.jsp").forward(request, response);
                }

            } else if ("find".equalsIgnoreCase(action)) {
                String lid = request.getParameter("lap_id");
                Laptop lp = LaptopDAO.findLaptopById(lid);
                request.setAttribute("result", (lp != null) ? lp : "Error finding laptop!");
                request.setAttribute("isSingle", true);
                request.getRequestDispatcher("donorDashboard.jsp").forward(request, response); // Forward to result page

            } else if ("findAll".equalsIgnoreCase(action)) {

                List<Laptop> lp = LaptopDAO.findAllLaptops();
                request.setAttribute("result", (lp != null) ? lp : "Error finding laptop.");
                request.setAttribute("isSingle", false);
                request.getRequestDispatcher("donorDashboard.jsp").forward(request, response); // Forward to result page
            }
        }
         response.sendRedirect("adminDashboard.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LaptopServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LaptopServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
