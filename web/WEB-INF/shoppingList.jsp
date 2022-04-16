<%-- 
    Document   : shoppingList
    Created on : 15-Apr-2022, 9:10:40 PM
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
        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>
        <h2>List</h2>
        
        <form action="" method="post">
            <label>Add Item: </label>
            <input type="text" name="addItem">
            <input type="submit" name="add" value="Add">
            <input tpye="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <ul>
            <c:if items="${itemlist.size() > 0}">
                <form action="ShoppingList" method ="post">
            <ul>
                <c:forEach items="${itemList}" var="item">
                    <li> <input type="radio" name="itemname" value=${item}>${item}</li>
                </c:forEach>
            </ul>
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
               
        </form>
            </c:if>
    </body>
</html>
