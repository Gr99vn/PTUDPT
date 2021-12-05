<%-- 
    Document   : home
    Created on : Dec 3, 2021, 12:27:04 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home page</h1>
        <h3>Welcome, <c:out value='${user.getUsername()}' /></h3>
        <a href="<c:url value='/add_book' />">Login</a>
        <table>
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Title</td>
                    <td>Price</td>
                    <td>Import Price</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.getId()}</td>
                    <td>${book.getTitle()}</td>
                    <td>${book.getPrice()}</td>
                    <td>${book.getImportPrice()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
