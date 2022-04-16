<%-- 
    Document   : register
    Created on : 15-Apr-2022, 9:10:20 PM
    Author     : honey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="Shopping List" method="post">
            <label>Username: </label>
            <input type="text" name="username" value="">
            <input type="submit" value="Register Name">
            <input type="hidden" name="action" value="register">
        </form>
        <c:if test="{error}">
            <p>No username Entered</p>
        </c:if>
    </body>
</html>
