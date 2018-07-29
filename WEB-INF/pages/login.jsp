<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>


    <title>Log in with your account</title>

</head>

<body>
<center>
    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2>Log in</h2>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <h2>
                <span>${message}</span>
            </h2>
            <h2>
                <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
            </h2>
            <h2>
                <input name="password" type="password" class="form-control" placeholder="Password"/>
            </h2>
            <h2>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </h2>
            <h2>
                <button type="submit">Log In</button>
            </h2>
            <h2>
                <a href="${contextPath}/registration">Create an account</a>
            </h2>
            <h2>
                <span>${error}</span>
            </h2>
        </div>
    </form>
</center>
</body>
</html>