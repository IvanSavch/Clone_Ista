<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 19.03.2025
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload picture</title>
</head>
<body>
<form method="post" action="/uploadPicture" enctype="multipart/form-data">
  <input type="file" name="photo">
  <button>Upload</button>
</form>
</body>
</html>
