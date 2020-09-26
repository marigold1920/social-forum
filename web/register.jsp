<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <c:set var="errorMessage" value="${requestScope.errorMessage}" />
        <c:set var="email" value="${requestScope.email}" />
        <c:set var="name" value="${requestScope.name}" />
        <c:if test="${not empty errorMessage}">
            <h2>${errorMessage}</h2>
        </c:if>
        <form action="ProcessServlet" method="post">
            Email: <input name="email" value="${email}" type="text" /> <br />
            Password: <input name="password" value="" type="password" /> <br />
            Name: <input name="name" value="${name}" type="text" />
            <button type="submit" name="action" value="register">Register</button>
        </form>
    </body>
</html>
