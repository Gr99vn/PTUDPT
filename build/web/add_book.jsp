<%-- 
    Document   : login
    Created on : Dec 3, 2021, 12:32:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="<c:url value='/add_book' />" method="POST">
            <label for="id">Id</label><br>
            <input type="text" name="id" id="id" value=""><br>
            <label for="title">Title</label><br>
            <input type="text" name="title" id="title" value=""><br>
            <label for="price">Price</label><br>
            <input type="text" name="price" id="price" value=""><br>
            <label for="importPrice">Import Price</label><br>
            <input type="text" name="importPrice" id="importPrice" value=""><br>
            <button type="submit">Add new book</button>
        </form>
    </body>
</html>
