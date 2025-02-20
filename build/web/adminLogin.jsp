<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login</title>
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
    p {
      font-size: 1rem;
      color: #9ca3af;
    }
    form {
      max-width: 400px;
      margin: 3rem auto;
      background-color: white;
      padding: 3rem;
      border-radius: 0.5rem;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    form h2 {
      text-align: center;
      margin-bottom: 1.5rem;
      color: #1f2937;
    }
    .form-group {
      margin-bottom: 1rem;
    }
    label {
      display: block;
      font-size: 1rem;
      margin-bottom: 0.5rem;
      color: #6b7280;
    }
    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 0.75rem;
      border: 1px solid #d1d5db;
      border-radius: 0.375rem;
      font-size: 1rem;
    }
    input[type="text"]:focus,
    input[type="password"]:focus {
      border-color: #3b82f6;
      outline: none;
    }
    button {
      width: 100%;
      background-color: #3b82f6;
      color: white;
      padding: 0.75rem;
      font-size: 1rem;
      font-weight: bold;
      border: none;
      border-radius: 0.375rem;
      margin-top: 1.5rem;
      cursor: pointer;
    }
    button:hover {
      background-color: #2563eb;
    }
    .toggle-links {
      text-align: center;
      margin-top: 1rem;
    }
    .toggle-links a {
      color: #3b82f6;
      text-decoration: none;
    }
    .toggle-links a:hover {
      text-decoration: underline;
    }
    .error-message {
        background-color: #f87171;
        color: white;
        padding: 1rem 2rem;
        border-radius: 0.375rem;
        text-align: center;
        max-width: 400px;
        margin: 2rem auto;
        font-weight: bold;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    footer {
      background-color: #1f2937;
      color: white;
      padding: 2rem;
      text-align: center;
      margin-top: 2rem;
    }
  </style>
</head>
<body>
  <header>
    <h1>Admin Portal</h1>
    <p>Access your account as Admin</p>
  </header>

    <% 
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    
    <div class="error-message">
        <strong><%= message %></strong>
    </div>
    <% 
        } 
    %>
  <form action="AdminServlet" method="POST">
    <h2>Login</h2>
    <input type="hidden" name="action" value="login">
    <div class="form-group">
      <label for="id">Admin ID</label>
      <input type="text" id="id" name="id" required />
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" id="passwd" name="passwd" required />
    </div>
    <button type="submit">Login</button>
  </form>

  <footer>
    <p>&copy; 2024 Digital Empowerment Platform. All Rights Reserved.</p>
  </footer>
</body>
</html>
