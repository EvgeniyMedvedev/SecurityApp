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
    <title>Title</title>
</head>
<body>

    <h2>Users</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Login</th>
            <th>Password</th>
        </tr>
        <c:forEach var="user" items="${usersList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>
                    <a href="/edit/${user.id}">Редактировать</a>
                    <a href="/delete/${user.id}">Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3>Добавить</h3>

    <form action="/add" method="post">
        <label for="name">Имя</label>
            <input type="text" name="name" id="name">
        <label for="login">Логин</label>
             <input type="text" name="login" id="login">
        <label for="password">Пароль</label>
            <input type="text" name="password" id="password">
        <input type="submit" value="Добавить">
    </form>

    <form action="/logout">
        <input type="submit" value="Выйти">
    </form>
</body>
</html>
