<%--suppress unchecked --%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
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
    List<String> lines=(ArrayList<String>) request.getAttribute("lines");
    for (String line: lines) {
%>
<tr>
    <td><%=line%></td><br>
</tr>
<%}%>
</body>
</html>
