<%@page import="com.team4.beans.Donor"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Donor Dashboard</title>
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
      padding: 2rem;
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
    <%
        // Retrieve the logged-in donor from the session
        session = request.getSession();
        Donor loggedInDonor = (Donor) session.getAttribute("loggedInDonor");
        
        // Check if the donor is logged in
    %>
  <header>
    <h1>Welcome to Your Donor Dashboard</h1>
    <p>Manage your donations and view request orders</p>
    <a class="admin-button" href='LogoutServlet'>Logout</a>
  </header>

  <div class="dashboard">

    <!-- Add Product Button -->
    <button onclick="window.location.href='addLaptop.jsp'">Add a Product</button>
    
    <button onclick="window.location.href='donorViewOrders.jsp'">View Order Requests</button>

  </div>

</body>
</html>
