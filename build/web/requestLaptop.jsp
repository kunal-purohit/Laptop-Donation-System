<%@page import="com.team4.beans.Student"%>
<%@ page import="com.team4.beans.Laptop" %>
<%@ page import="com.team4.servlet.LaptopServlet"%>
<%@ page import="com.team4.dao.LaptopDAO"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard - Available Laptops</title>
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
    .logout-btn {
      background-color: #ef4444;
    }
    .logout-btn:hover {
      background-color: #dc2626;
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
        <h1>Student Dashboard</h1>
        <p>Select a Laptop and Submit Your Request</p>
        <a href="studentViewOrders.jsp" class="admin-button">View Requests</a>
        
    </header>

    <div class="container">
        <h2>Available Laptops</h2>
        <form action="laptop" method="POST">
            <input type="hidden" name="action" value="req">
                         <%
            // Retrieve the logged-in donor from the session
            session = request.getSession();
            Student loggedInStudent = (Student) session.getAttribute("loggedInStudent");
            
             session = request.getSession();
            session.setAttribute("loggedInStudent", loggedInStudent);
  
           %> 
        <input type="hidden" name="s_id" value="<%=loggedInStudent.getsId() %>">
                        
            <table>
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>Laptop ID</th>
                        <th>Brand</th>
                        <th>Processor</th>
                        <th>RAM</th>
                        <th>Storage</th>
                        <th>Number of Devices</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Laptop> laptops = (List<Laptop>) LaptopDAO.findAllLaptops();
                        if (laptops != null) {
                            for (Laptop laptop : laptops) {
                            if( laptop.getNoOfDevices() > 0){
                    %>
                    <tr>
                        <td>
                            <input type="radio" name="lap_id" value="<%= laptop.getlapId() %>" required />
                        </td>
                        <td><%= laptop.getlapId() %></td>
                        <td><%= laptop.getBrand() %></td>
                        <td><%= laptop.getProcessor() %></td>
                        <td><%= laptop.getRam() %></td>
                        <td><%= laptop.getStorage() %></td>
                        <td><%= laptop.getNoOfDevices() %></td>
                    </tr>
                    <%
                            }
                        }} else {
                    %>
                    <tr>
                        <td colspan="7">No laptops available at the moment.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>

            </table>
            <button type="submit" class="form-submit">Request Selected Laptop</button>
        </form>
    </div>

</body>
</html>
