<%--
  Created by IntelliJ IDEA.
  User: Nout
  Date: 06.11.2019
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Service</h1>
    <h2>
        <a href="/add">Add New User</a>


    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Job</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.job}"/></td>
                <td><c:out value="${user.salary}"/></td>
                <td>
                    <a href="update?id=<c:out value='${user.id}' />">Update</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="location.href='/home'">Home</button>
</div>
</body>
</html>
