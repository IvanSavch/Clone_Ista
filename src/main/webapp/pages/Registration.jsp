
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/registration">
    <input type="text" name="name" placeholder="name" >
    <input type="text" name="userName" placeholder="user name" >
    <input type="password" name="password" placeholder="password">
    <button>enter</button>
</form>
<p>${message}</p>
</body>
</html>
