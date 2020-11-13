<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 04.11.2020
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Просмотр всех книг</title>
</head>
<body>

<%--<c:forEach var="b" items="${allBooks} ">--%>
<%--    <p>${b.getId()}, ${b.getName()} </p>--%>
<%--</c:forEach>--%>

<c:forEach var="b" items="${allBooks}">
    <p><c:out value="${b.getId()}"/>, <c:out value="${b.getName()}"/></p>
</c:forEach>

</body>
</html>
