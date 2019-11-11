<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Title</title>
</head>
<body>
<form method="POST">

    <label>Id:
        <input type="text" name="id" value="<%= request.getAttribute("id") %>" disabled><br/>
    </label>

    <label>Name:
        <input type="text" name="name" value="<%= request.getAttribute("name") %>"><br/>
    </label>

    <label>Job:
        <input type="text" name="job" value="<%= request.getAttribute("job") %>"><br/>
    </label>

    <label>Salary:
        <input type="text" name="salary" value="<%= request.getAttribute("salary") %>"><br/>
    </label>

    <button type="submit">Update</button>

</form>
<button onclick="location.href='/home'">Home</button>
</body>
</html>
