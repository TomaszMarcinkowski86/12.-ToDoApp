
<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 04.08.2019
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Register</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/register">
    Login: <input type="text" name="login" />
    Hasło: <input type="password" name="password" />
    e-mail: <input type="email" name="email" />
    <button type="submit" class="btn btn-primary">Register!</button>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/jquery.min.js"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>