<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
    <c:if test="${not empty error}">
        ${error}
    </c:if>
        <form name="form_login" action = "/login/process" method = "POST" >
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name = "login"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit"/></td>
                </tr>
            </table>
        </form>
</body>
</html>
