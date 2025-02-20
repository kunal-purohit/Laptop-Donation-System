<%@page import="com.team4.beans.Requests"%>
<%@page import="com.team4.beans.Student"%>
<%@page import="com.team4.servlet.LaptopServlet"%>
<%@page import="com.team4.dao.RequestDAO"%>
<%@page import="com.team4.dao.LaptopDAO"%> <%-- Assuming you have a LaptopDAO to fetch laptop details --%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard - Requests</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                font-family: 'Helvetica Neue', Arial, sans-serif;
                background-color: #f8f9fa;
                color: #333;
                line-height: 1.6;
            }
            header {
                background-color: #1f2937;
                color: white;
                padding: 1rem;
                text-align: center;
            }
            h1 {
                font-size: 2rem;
                font-weight: bold;
            }
            .admin-button {
      position: absolute;
      top: 1rem;
      right: 1rem;
      background-color: #a343e8;
      color: white;
      padding: 0.75rem 1.5rem;
      border-radius: 0.375rem;
      text-decoration: none;
      font-weight: 600;
    }
            .container {
                max-width: 1200px;
                margin: 3rem auto;
                padding: 2rem;
                background-color: white;
                border-radius: 0.5rem;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            .container h2 {
                font-size: 1.75rem;
                color: #1f2937;
                margin-bottom: 1.5rem;
                text-align: center;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 2rem;
            }
            table th, table td {
                border: 1px solid #d1d5db;
                padding: 1rem;
                text-align: center;
            }
            table th {
                background-color: #f3f4f6;
                font-weight: bold;
            }
            table tr:nth-child(even) {
                background-color: #f8f9fa;
            }
            .form-group {
                margin-bottom: 1.5rem;
            }
            .form-submit {
                background-color: #3b82f6;
                color: white;
                padding: 1rem;
                font-size: 1rem;
                font-weight: bold;
                border: none;
                border-radius: 0.375rem;
                width: 100%;
                cursor: pointer;
            }
            .form-submit:hover {
                background-color: #2563eb;
            }
            .back-btn {
                display: block;
                margin-top: 1rem;
                text-align: center;
                color: #3b82f6;
                text-decoration: none;
            }
            footer {
                background-color: #1f2937;
                color: white;
                padding: 2rem;
                text-align: center;
                margin-top: 3rem;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Admin Dashboard</h1>
            <p>Manage Laptop Requests</p>
            <a href="LogoutServlet" class="admin-button">Admin Logout</a>
        </header>

        <div class="container">
            <h2>Request List</h2>
            <input type="hidden" name="action" value="req">
            <%
                // Retrieve the logged-in admin from the session if needed
                // session = request.getSession();
                // Admin loggedInAdmin = (Admin) session.getAttribute("loggedInAdmin");
            %> 

            <table>
                <thead>
                    <tr>
                        <th>Request ID</th>
                        <th>Student ID</th>
                        <th>Laptop ID</th>
                        <th>Request Date</th>
                        <th>Request Status</th>
                        <th>Available Stocks</th>
                        <th>Approve</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Requests> reqList = RequestDAO.findAllRequests();
                        if (reqList != null && !reqList.isEmpty()) {
                            for (Requests r : reqList) {
                                int availableStock = LaptopDAO.getAvailableStock(r.getLapId());
                    %>
                    <tr>
                        <td><%= r.getReqId()%></td>
                        <td><%= r.getsId()%></td>
                        <td><%= r.getLapId()%></td>
                        <td><%= r.getReqDate()%></td>
                        <td><%= r.getReqStatus()%></td>
                        <td><%= availableStock%></td>
                        <td>
                            <form action="adminDashboard.jsp" method="post">
                                <input type="hidden" name="action" value="approve">
                                <input type="hidden" name="reqId" value="<%= r.getReqId()%>">
                                <input type="hidden" name="lapId" value="<%= r.getLapId()%>">
                                <button type="submit" class="form-submit">Approve</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="7">No requests available at the moment.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <footer>
            <p>&copy; 2024 Team 4. All rights reserved.</p>
        </footer>
    </body>
</html>
