<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Student Registration</title>
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
    input[type="date"],
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
    input[type="date"]:focus,
    input[type="email"]:focus,
    input[type="password"]:focus,
    input[type="tel"]:focus {
      border-color: #3b82f6;
      outline: none;
    }
    select {
      width: 100%;
      padding: 0.75rem;
      border: 1px solid #d1d5db;
      border-radius: 0.375rem;
      font-size: 1rem;
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
    <h1>Student Registration</h1>
    <p>Join us and access digital learning resources with a donated laptop</p>
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
  <form action="student" method="post">
      <input type="hidden" name="action" value="add">
    <h2>Register as a Student</h2>
    <div class="form-group">
      <label for="s_name">Student Name</label>
      <input type="text" id="s_name" name="s_name" required />
    </div>
    <div class="form-group">
      <label for="s_dob">Date of Birth</label>
      <input type="date" id="s_dob" name="s_dob" required />
    </div>
    <div class="form-group">
      <label for="s_email">Email</label>
      <input type="email" id="s_email" name="s_email" required />
    </div>
    <div class="form-group">
      <label for="s_mob">Mobile Number</label>
      <input type="tel" id="s_mob" name="s_mob" pattern="[6-9][0-9]{9}" required />
    </div>
    <div class="form-group">
      <label for="s_zip">ZIP Code</label>
      <input type="text" id="s_zip" name="s_zip" pattern="[0-9]{6}" required />
    </div>
    <div class="form-group">
      <label for="s_village_town">Village/Town</label>
      <input type="text" id="s_village_town" name="s_village_town" required />
    </div>
    <div class="form-group">
      <label for="s_state">State</label>
      <input type="text" id="s_state" name="s_state" required />
    </div>
    <div class="form-group">
      <label for="father_name">Father's Name</label>
      <input type="text" id="father_name" name="father_name" required />
    </div>
    <div class="form-group">
      <label for="mother_name">Mother's Name</label>
      <input type="text" id="mother_name" name="mother_name" required />
    </div>
    <div class="form-group">
      <label for="family_income">Family Income</label>
      <select id="family_income" name="family_income" required>
        <option value="">-- Select Family Income --</option>
        <option value="Less than 1 lakh">Less than 1 lakh</option>
        <option value="Between 1 - 5 lakhs">Between 1 - 5 lakhs</option>
        <option value="Between 5 - 8 lakhs">Between 5 - 8 lakhs</option>
        <option value="Above 8 lakhs">Above 8 lakhs</option>
      </select>
    </div>
    <div class="form-group">
      <label for="father_occupation">Father's Occupation</label>
      <input type="text" id="father_occupation" name="father_occupation" />
    </div>
    <div class="form-group">
      <label for="mother_occupation">Mother's Occupation</label>
      <input type="text" id="mother_occupation" name="mother_occupation" />
    </div>
    <div class="form-group">
      <label for="father_mob">Father's Mobile Number</label>
      <input type="tel" id="father_mob" name="father_mob" pattern="[6-9][0-9]{9}" />
    </div>
    <div class="form-group">
      <label for="mother_mob">Mother's Mobile Number</label>
      <input type="tel" id="mother_mob" name="mother_mob" pattern="[6-9][0-9]{9}" />
    </div>
    <div class="form-group">
      <label for="curr_studying">Currently Studying In</label>
      <select id="curr_studying" name="curr_studying" required>
        <option value="">-- Select Course --</option>
        <option value="Primary School">Primary School</option>
        <option value="High School">High School</option>
        <option value="Degree College">Degree College</option>
      </select>
    </div>
    <div class="form-group">
      <label for="institute">Institute</label>
      <input type="text" id="institute" name="institute" required />
    </div>
    <div class="form-group">
      <label for="reg_no">Registration Number</label>
      <input type="text" id="reg_no" name="reg_no" required />
    </div>
    <div class="form-group">
      <label for="s_password">Password</label>
      <input type="password" id="s_password" name="s_password" required />
    </div>
    <button type="submit">Register</button>
  </form>

  <footer>
    <p>&copy; 2024 Digital Empowerment Platform. All Rights Reserved.</p>
  </footer>
</body>
</html>
