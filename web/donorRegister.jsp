<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Donor Registration</title>
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
    p {
      font-size: 1rem;
      color: #9ca3af;
    }
    form {
      max-width: 600px;
      margin: 3rem auto;
      background-color: white;
      padding: 2rem;
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
    input[type="email"],
    input[type="password"],
    input[type="tel"] {
      width: 100%;
      padding: 0.75rem;
      border: 1px solid #d1d5db;
      border-radius: 0.375rem;
      font-size: 1rem;
    }
    input[type="text"]:focus,
    input[type="email"]:focus,
    input[type="password"]:focus,
    input[type="tel"]:focus {
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
    .error-message {
        background-color: #f87171;
        color: white;
        padding: 1rem 2rem;
        border-radius: 0.375rem;
        text-align: center;
        max-width: 600px;
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
    <h1>Donor Registration</h1>
    <p>Make a difference by donating for a cause and help students access technology</p>
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
  
  <form action="donor" method="post">
    <h2>Register as a Donor</h2>
     <input type="hidden" id="d_name" name="action" value="add" />
    <div class="form-group">
      <label for="d_name">Donor Name</label>
      <input type="text" id="d_name" name="d_name" required />
    </div>
    <div class="form-group">
      <label for="d_email">Email</label>
      <input type="email" id="d_email" name="d_email" required />
    </div>
    <div class="form-group">
      <label for="d_mob">Mobile Number</label>
      <input type="tel" id="d_mob" name="d_mob" pattern="[6-9][0-9]{9}" required />
    </div>
    <div class="form-group">
      <label for="d_town_city">Town/City</label>
      <input type="text" id="d_town_city" name="d_town_city" required />
    </div>
    <div class="form-group">
      <label for="d_state">State</label>
      <input type="text" id="d_state" name="d_state" required />
    </div>
    <div class="form-group">
      <label for="d_zip">ZIP Code</label>
      <input type="text" id="d_zip" name="d_zip" pattern="[0-9]{6}" required />
    </div>
    <div class="form-group">
      <label for="d_password">Password</label>
      <input type="password" id="d_password" name="d_password" required />
    </div>
    <button type="submit">Register</button>
  </form>

  <footer>
    <p>&copy; 2024 Digital Empowerment Platform. All Rights Reserved.</p>
  </footer>
</body>
</html>
