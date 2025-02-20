<%@page import="com.team4.beans.Donor"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Add Laptop</title>
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
    .form-container {
      max-width: 600px;
      margin: 3rem auto;
      padding: 2rem;
      background-color: white;
      border-radius: 0.5rem;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .form-container h2 {
      font-size: 1.75rem;
      color: #1f2937;
      margin-bottom: 1.5rem;
      text-align: center;
    }
    .form-group {
      margin-bottom: 1.5rem;
    }
    .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 0.5rem;
    }
    .form-group input, .form-group select {
      width: 100%;
      padding: 0.75rem;
      font-size: 1rem;
      border: 1px solid #d1d5db;
      border-radius: 0.375rem;
    }
    .form-group input:focus, .form-group select:focus {
      border-color: #3b82f6;
      outline: none;
      box-shadow: 0 0 0 3px rgba(59, 130, 246, 0.3);
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
    <h1>Add Laptop</h1>
    <p>Donate a Laptop to Help a Student in Need</p>
    
  </header>
        <%
            // Retrieve the logged-in donor from the session
            session = request.getSession();
            Donor loggedInDonor = (Donor) session.getAttribute("loggedInDonor");
        %>

    
  <div class="form-container">
      
    <h2>Enter Laptop Details</h2>
    <form action="laptop" method="POST">
        <input type="hidden" name="action" value="add">
      <!-- Laptop ID -->
      

      <!-- Brand -->
      <div class="form-group">
        <label for="brand">Brand</label>
        <input type="text" id="brand" name="brand" placeholder="Enter brand" required />
      </div>

      <!-- Processor -->
      <div class="form-group">
        <label for="processor">Processor</label>
        <input type="text" id="processor" name="processor" placeholder="Enter processor" />
      </div>

      <!-- RAM -->
      <div class="form-group">
        <label for="ram">RAM</label>
        <input type="text" id="ram" name="ram" placeholder="Enter RAM size" />
      </div>

      <!-- Storage -->
      <div class="form-group">
        <label for="storage">Storage</label>
        <input type="text" id="storage" name="storage" placeholder="Enter storage size" />
      </div>

      <!-- Number of Devices -->
      <div class="form-group">
        <label for="no_of_devices">Number of Devices</label>
        <input type="number" id="no_of_devices" name="no_of_devices" placeholder="Enter number of devices" required />
      </div>

      <!-- Donor ID (Hidden field assuming donor is logged in) -->
        <input type="hidden" name="did" value="<%= loggedInDonor.getdId()%>"><br>
      <!-- Submit Button -->
      <button type="submit" class="form-submit">Add Laptop</button>
    </form>
    <a href="donorDashboard.jsp" class="back-btn">Back to Dashboard</a>
  </div>
  <footer>
    <p>&copy; 2024 Digital Empowerment Platform. All Rights Reserved.</p>
  </footer>
</body>
</html>
