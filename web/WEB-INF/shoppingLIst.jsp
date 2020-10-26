<%-- 
    Document   : shoppingLIst
    Created on : Oct 18, 2020, 10:44:53 PM
    Author     : 703922
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
      <h1>Shopping List</h1>
        <div>
            Hello, ${username} <a href="<c:url value='/ShoppingList'>
                                      <c:param name='action' value='logout'/>
            </c:url>" >Logout</a>
        </div>
        <h2>List</h2>
        <div>
            <form method="post" action="<c:url value='/ShoppingList'>
                            <c:param name='action' value='add'/>
                  </c:url>">
                Add item: <input type="text" name="addItem" value="${addItem}" required/> <button type="submit">Add</button>
            </form>
        </div>
            <c:if test="${!userAndItems.isEmpty()}">
                <form method="post" action="<c:url value='/ShoppingList'>
                            <c:param name='action' value='delete'/>
                  </c:url>">
                <c:forEach var="item" items="${userAndItems.get(username)}" varStatus="status">
                    <p>
                        <input type="radio" id="${item}" name="item" value="${status.index}" required/>
                        <label for="${item}">${item}</label>
                    </p>
                </c:forEach>
                    <button type="submit">Delete</button>
                </form>
            </c:if>
    </body>
</html>
