<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Robert
  Date: 10.10.2021
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> lines=(ArrayList<String>) request.getAttribute("lines");
    for (String line: lines) {
%>
<tr>
    <td><%=line%></td><br>
</tr>
<%}%>
</body>
</html>
