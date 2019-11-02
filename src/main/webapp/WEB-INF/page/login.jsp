<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

</head>

<body>

<div class="container">

    <c:if test="${error}">Введены неверно логин или пароль.</c:if>
    <form action="/login" method="POST">
        <input type="text" placeholder="login" name="login" required>
        <input type="text" placeholder="password" name="password" required>
        <input type="submit" value="Login"/>
    </form>
    <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>

</div>

</body>
</html>