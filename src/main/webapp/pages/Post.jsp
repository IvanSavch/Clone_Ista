<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 22.03.2025
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<form method="post" action="/post" enctype="multipart/form-data">
  <input type="file" name="postPhoto">
  <input type="text" name="description" placeholder="description">
  <button>Upload</button>
</form>
</body>
</html>
