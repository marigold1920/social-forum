<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Social Forum</title>
    </head>
    <body>
        <c:set var="error" value="${requestScope.error}" />
        <c:if test="${not empty error}">
            <h2>${error}</h2>
        </c:if>
        <form action="ProcessServlet" method="post">
            Username: <input name="username" value="" type="text" /> <br />
            Password: <input name="password" value="" type="password" /> <br />
            Name: <input name="name" value="" type="text" />
            <button type="submit" name="action" value="Login">Login</button>
        </form>
    </body>
</html>
