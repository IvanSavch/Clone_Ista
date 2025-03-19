<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 14.03.2025
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<img src="data:image/jpeg;base64,${photo}">
<a href="/uploadPicture">upload</a>
<p>${sessionScope.user.name}</p>

</body>
</html>
