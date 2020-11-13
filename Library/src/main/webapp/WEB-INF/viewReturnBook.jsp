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
<form method="post" action="/returnBook">
    <p>Выберите книгу для возврата</p>
    <select name="reader" size="1" >
        <c:forEach var="b" items="${allBooks}">
            <option value=<c:out value="${b.getReader().getId()}"/>> <c:out value="${b.getName()}"/></option>
        </c:forEach>
    </select>



    <button type="submit">Вернуть книгу</button>

</form>
</body>
</html>
