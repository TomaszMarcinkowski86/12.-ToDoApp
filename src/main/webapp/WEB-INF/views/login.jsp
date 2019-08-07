<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:choose>
    <c:when test="${valid == false}">
        <div class="alert alert-danger">Podano złe dane logowania</div>
    </c:when>
</c:choose>
<form method="POST" action="${pageContext.request.contextPath}/login">
    Login: <input type="text" name="login" />
    Hasło: <input type="password" name="password" />
    <button type="submit" class="btn btn-primary">Log in!</button>
</form>

<form method="GET" action="/register">
    <button type="submit" class="btn btn-primary">Register!</button>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/jquery.min.js"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
