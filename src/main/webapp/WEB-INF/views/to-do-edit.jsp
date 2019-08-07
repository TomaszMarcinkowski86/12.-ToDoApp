<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 04.08.2019
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>EDIT</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="/to-do/edit" method="POST">
    <div class="form-group">
        <label for="title">Title</label>
        <input type="text" id="title" name="title" value="${todo.title}" required/>
    </div>
    <div class="form-group">
        <label>Categories</label>
        <select name="category">
            <option selected>${todo.category}</option>
            <c:forEach items="${categories}" var="category">
                <c:if test="${category != todo.category}">
                    <option value="${category}">${category}</option>
                </c:if>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="deadlineDate">Deadline</label>
        <input type="datetime-local" id="deadlineDate" name="deadlineDate" value="${todo.deadlineDate}" required>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <input type="text" id="description" name="description" value="${todo.description}" required>
    </div>
    <input type="hidden" name="id" value="${todo.id}">
    <button type="submit" class="btn btn-success" name="saveButton">Update
    </button>
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/jquery.min.js"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
