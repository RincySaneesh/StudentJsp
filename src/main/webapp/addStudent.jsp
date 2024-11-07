<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add New Student</title>
  <style>
    /* Resetting default margins and padding */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: Arial, sans-serif;
    }

    /* Background and centering */
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f0f2f5;
    }

    /* Container for the form */
    .form-container {
      width: 300px;
      padding: 2rem;
      background-color: #ffffff;
      box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      text-align: center;
    }

    /* Headline for the form */
    .form-container h2 {
      margin-bottom: 1.5rem;
      color: #333;
      font-size: 1.5rem;
    }

    /* Labels for inputs */
    .form-container label {
      display: block;
      text-align: left;
      font-size: 0.9rem;
      color: #555;
      margin-bottom: 0.5rem;
      margin-top: 1rem;
    }

    /* Styling input fields */
    .form-container input[type="text"] {
      width: 100%;
      padding: 10px;
      margin: 8px 0;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 1rem;
    }

    /* Buttons for save and back to home */
    .form-container .save-btn,
    .form-container .back-btn {
      width: 100%;
      padding: 10px;
      border: none;
      border-radius: 5px;
      font-size: 1rem;
      cursor: pointer;
      margin-top: 1rem;
      color: #ffffff;
      background-color: #007bff;
    }

    .form-container .save-btn:hover,
    .form-container .back-btn:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
  <div class="form-container">
    <h2>Add New Student</h2>
    <form action="Save" method="post">
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" required>

      <label for="rollno">Roll Number:</label>
      <input type="text" id="rollno" name="rollno" required>

      <label for="department">Department:</label>
      <input type="text" id="department" name="department" required>

      <button type="submit" class="save-btn">Save</button>
      <button type="button" class="back-btn" onclick="window.location.href='home.jsp'">
        &larr; Back to Home
      </button>
    </form>
  </div>
</body>
</html>
