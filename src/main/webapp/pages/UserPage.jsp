<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 19.03.2025
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>
<div>
    <img src="data:image/jpeg;base64,${userPicture}">
    <br>

    <form method="post" action="userPage">
        <input type="hidden" name="userName" value="${userName}">
        <button>sub</button>
    </form>
    <br>
    <a href="http://localhost:8090/subscription?userName=${userName}"> subscription </a>
    <br>
    <c:forEach items="${users}" var="user">
        <c:set var="imgByte" value="${Base64.getEncoder().encodeToString(user.picture)}"/>
        <img src="data:image/jpeg;base64,${imgByte}">
        <li>${user.description}</li>
    </c:forEach>
</div>
<br>

<p>${notFound}</p>
</body>
</html>
