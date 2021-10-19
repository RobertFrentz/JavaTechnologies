<%--
  Created by IntelliJ IDEA.
  User: Robert
  Date: 17.10.2021
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<body>
<table>
    <tr>
        <th>Category</th>
        <th>Key</th>
        <th>Value</th>
    </tr>
    <c:forEach var="record" items="${requestScope.recordsData}">
        <tr>
            <td>${record.category.name}</td>
            <td>${record.key}</td>
            <td>${record.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>