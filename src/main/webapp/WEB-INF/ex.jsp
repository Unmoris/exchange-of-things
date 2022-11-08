<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="/main">Hello Bitch</a>
<form action = "main" method = "POST">
    First Name: <input type = "text" name = "first_name">
    <br />
    Last Name: <input type  = "text" name = "last_name" />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>