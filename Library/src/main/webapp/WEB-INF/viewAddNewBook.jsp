<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 07.11.2020
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Форма добавления книги</title>
</head>
<body>
<form method="post" action="/addNewBook">
    <input name="book"/>
    <input name="author"/>
    <button type="submit">Добавить</button>
</form>
</body>
</html>
