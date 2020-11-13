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
    <title>Title</title>
</head>
<body>
<form method="post" action="/giveBook">
<p>Выберите книгу</p>
<select name="book" size="1" >
    <c:forEach var="r" items="${allBooks}">
        <option value=<c:out value="${r.getId()}"/>> <c:out value="${r.getName()}"/></option>
    </c:forEach>
</select>
<p>Выберите читателя</p>
    <select name="reader" size="1" >
        <c:forEach var="b" items="${allReaders}">
            <option value=<c:out value="${b.getId()}"/>> <c:out value="${b.getName()}"/></option>
        </c:forEach>
    </select>



<button type="submit">Выдать книгу</button>

</form>
</body>
</html>
