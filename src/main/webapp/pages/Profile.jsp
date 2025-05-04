<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 14.03.2025
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<img src="data:image/jpeg;base64,${profilePhoto}">
<br>
<a href="/uploadPicture">upload</a>
<p>${sessionScope.user.name}</p>
<br>
<a href="/post">Add post</a>
<br>
<a href="/search"></a>
<br>

<%--<c:forEach items="${postPicture}" var="pictures">--%>
<%--    <img src="data:image/jpeg;base64,${pictures}">--%>
<%--</c:forEach>--%>

<c:forEach items="${posts}" var="post">
    <c:set var="imgByte" value="${Base64.getEncoder().encodeToString(post.picture)}" />
    <img src="data:image/jpeg;base64,${imgByte}">
    <li>${post.description}</li>
</c:forEach>
</body>
</html>
