<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <c:set var="errorMessage" value="${requestScope.errorMessage}" />
        <c:set var="email" value="${requestScope.email}" />
        <c:if test="${not empty errorMessage}">
            <h2>${errorMessage}</h2>
        </c:if>
        <form action="ProcessServlet" method="post">
            Email: <input name="email" value="${email}" type="text" /> <br />
            Password: <input name="password" value="" type="password" /> <br />
            <button type="submit" name="action" value="login">Login</button>
        </form>
    </body>
</html>
