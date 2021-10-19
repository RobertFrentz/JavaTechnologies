<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Input</title>
</head>
<body>
<form method="POST" action="controller-servlet">
    <input type="text" name="category" value="${requestScope.category.name}">
    <input type="text" name="key" placeholder="key">
    <input type="text" name="value" placeholder="value">
    <input type="submit" value="Submit">
</form>
</body>
</html>