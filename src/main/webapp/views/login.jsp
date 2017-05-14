<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/web-resources/"/>/css/bootstrap.min.css" rel = "stylesheet"/>
    <title>Authorization</title>
</head>
<body>
    <c:if test="${not empty error}">
     <p>${error}</p>
    </c:if>
        <form name="form_login" action = "/login/process" method = "POST" class="form-inline" >
            <div class="form-group">
                <label for="inputName">User:</label>
                <input type="text" name = "login" id="inputName" placeholder="DartVeider"/>
            </div>
            <div class="form-group">
                <label for="inputPassword">Password:</label>
                <input type="password" name="password" id="inputPassword" placeholder="enterMe1234"/>
            </div>
            <div class="form-group">
                <label for="selectRemember">Remember me</label>
                <input type="checkbox" name="rememberMe" id="selectRemember"/>
            </div>
                <button type="submit" class="btn btn-default">Send</button>
        </form>
</body>
</html>
