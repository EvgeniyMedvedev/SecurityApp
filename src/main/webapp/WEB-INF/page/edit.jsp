<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thele
  Date: 17.10.2019
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Редактирование</h2>

<form action="/edit" method="post">
    <input type="hidden" name="id" value="${user.id}">

    <label for="name">Имя</label>
        <input type="text" name="name" id="name" value="${user.name}">
    <label for="login">Логин</label>
        <input type="text" name="login" id="login" value="${user.login}">
    <label for="password">Пароль</label>
        <input type="text" name="password" id="password" value="${user.password}">
    <input type="submit" value="Edit user">

</form>
</body>
</html>
