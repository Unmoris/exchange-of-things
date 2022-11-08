<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: micla
  Date: 04.11.2022
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using GET and POST Method to Read Form Data</title>
</head>

<body>
<h1>Using POST Method to Read Form Data</h1>

<ul>
    <li><p><b>First Name:</b>
        <%= request.getParameter("login")%>
    </p></li>
    <li><p><b>Last Name:</b>
        <%= request.getParameter("password")%>
    </p></li>
    <c:if test="${not empty password}">
    <li><p><b>Pass:</b>
        <%= session.getAttribute("password")%>
    </p></li>
    </c:if>
</ul>

<form action="main" method="POST">
    Password: <input type="text" name="password">
    <br/>
</form>

</body>
</html>