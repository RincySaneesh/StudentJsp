
<!DOCTYPE html>
<html>
<head>
    <title>Student</title>
    <style>
        body {
            font-family: 'Georgia', serif;
            background-color: #f9f8f7;
            margin: 0;
            padding: 0;
            color: #333;
        }

        .container {
            margin: 0 auto;
            max-width: 600px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-top: 50px;
        }

        h2 {
            margin-bottom: 30px;
            font-size: 28px;
            color: #4a4a4a;
        }

        .button {
            display: inline-block;
            margin: 10px;
            padding: 15px 25px;
            font-size: 18px;
            color: white;
            background-color: #b0b0b0;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            border: 2px solid #a0a0a0;
            transition: background-color 0.3s, border-color 0.3s;
        }

        .button:hover {
            background-color: #9a9a9a;
            border-color: #888888;
        }

        .button:active {
            background-color: #8a8a8a;
            border-color: #666666;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to MySchool </h2>
        <a href="signup.jsp" class="button">New User</a><br>
        <a href="login.jsp" class="button">Login</a><br>
         <a href="addStudent.jsp" class="button">Add Student</a>
          <a href="welcome.jsp" class="button">Welcome</a>

    </div>
</body>
</html>
