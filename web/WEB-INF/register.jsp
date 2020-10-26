<%-- 
    Document   : register
    Created on : Oct 18, 2020, 10:44:40 PM
    Author     : 703922
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            <form method="post" action="<c:url value='/ShoppingList'>
                            <c:param name='action' value='register'/>
                  </c:url>">
                Username: <input type="text" name="user" value="${user}" required/> <button type="submit">Register name</button>
            </form>
        </div>
    </body>
</html>
