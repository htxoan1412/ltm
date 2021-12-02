<%--
  Created by IntelliJ IDEA.
  User: ran
  Date: 8/17/2021
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="/checkLogin">
  UserName :<input type="text" name="username" ><br>
  Password :<input type="password" name="pass"><br>
  <button type="submit">Submit</button>
</form>

</body>
</html>
