<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 14.03.2025
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<form method="post" action="/login">
  <input type="text" name="userName" placeholder="user name" >
  <input type="password" name="password" placeholder="password">
  <button>enter</button>
</form>
<p>${message}</p>
</body>
</html>
