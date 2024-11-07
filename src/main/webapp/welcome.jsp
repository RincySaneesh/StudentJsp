<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Students Are..</title>

    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 16px;
            text-align: center;
            font-size: 14px;
            cursor: pointer;
            border-radius: 4px;
        }

        button.delete {
            background-color: #f44336;
        }

        .add-student-button {
            background-color: #008CBA;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 20px;
        }

        .add-student-button:hover {
            background-color: #005f6a;
        }
    </style>
</head>
<body>

<h2>You Are Welcome</h2>
<h3>Student Details</h3>

<form action="AddStudent.jsp" method="get">
    <input type="submit" class="add-student-button" value="Add Student">
</form>

<table>
    <tr>
        <th>Sl.No</th>
        <th>RollNo</th>
        <th>Username</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <tr>
        <td>1</td>
        <td>1001</td>
        <td>john_doe</td>
        <td>password123</td>
        <td>
            <button>Edit</button>
            <button class="delete">Delete</button>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>1002</td>
        <td>jane_smith</td>
        <td>password456</td>
        <td>
            <button>Edit</button>
            <button class="delete">Delete</button>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>1003</td>
        <td>sam_brown</td>
        <td>password789</td>
        <td>
            <button>Edit</button>
            <button class="delete">Delete</button>
        </td>
    </tr>
</table>

</body>
</html>
