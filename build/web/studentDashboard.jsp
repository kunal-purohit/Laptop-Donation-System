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
        .dashboard {
            max-width: 600px;
            margin: 3rem auto;
            padding: 2rem;
            background-color: white;
            border-radius: 0.5rem;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .dashboard h2 {
          font-size: 1.75rem;
          color: #1f2937;
          margin-bottom: 2rem;
        }
        .dashboard button {
            display: block;
            width: 100%;
            padding: 1rem;
            font-size: 1rem;
            font-weight: bold;
            color: white;
            background-color: #3b82f6;
            border: none;
            border-radius: 0.375rem;
            margin-bottom: 1rem;
            cursor: pointer;
        }
        .dashboard button:hover {
            background-color: #2563eb;
        }
        .logout-btn {
            background-color: #ef4444;
        }
        .logout-btn:hover {
            background-color: #dc2626;
        }
    </style>
</head>
<body>
    <header>
        <h1>Student Dashboard</h1>
        <a class="admin-button" href="LogoutServlet">Logout</a>
    </header>

    <div class="dashboard">
        <button onclick="window.location.href='requestLaptop.jsp'">Request Laptop</button>
        <button onclick="window.location.href='studentViewOrders.jsp'">View Order Requests</button>
    </div>

</body>
</html>
