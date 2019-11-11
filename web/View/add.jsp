<%--
  Created by IntelliJ IDEA.
  User: Nout
  Date: 06.11.2019
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form method="POST">
    <label>Name:
        <input type="text" name="name"><br/>
    </label>

    <label>Job:
        <input type="text" name="job"><br/>
    </label>

    <label>Salary:
        <input type="text" name="salary"><br/>
    </label>

    <button type="submit">Submit</button>

</form>
    <button onclick="location.href='/home'">Home</button>
</body>
</html>
