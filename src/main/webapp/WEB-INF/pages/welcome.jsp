<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <title>Welcome</title>
    </head>

    <body>
    <center>
        <h1>
            <a href="<c:url value="/books/${username}"/>" target="_blank">View the list of books</a>
        </h1>
        <h1>
            <a href="<c:url value="/admin/${username}"/>" target="_blank">Admin page </a>
        </h1>
        <h1>
            ${username}
        </h1>
    </center>
    </body>
</html>