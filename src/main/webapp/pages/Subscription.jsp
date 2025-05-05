<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 05.05.2025
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Subscriptions</title>
</head>
<body>
<c:forEach items="${subscriptions}" var="sub">
    <li>${sub}</li>
</c:forEach>
</body>
</html>
