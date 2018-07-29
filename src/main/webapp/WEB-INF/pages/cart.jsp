<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Cart</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
<c:if test="${!empty cartList}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Username</th>
            <th width="120">Book ID</th>
            <th width="120">Price</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
        </tr>
        <c:forEach items="${cartList}" var="cart">
            <tr>
                <td>${cart.id}</td>
                <td>${cart.username}</td>
                <td>${cart.book_id}</td>
                <td>${cart.book.price/100}${cart.book.price%100}</td>
                <td>${cart.book.bookTitle}</td>
                <td>${cart.book.bookAuthor}</td>
                <td><a href="<c:url value='/removeOrderCart/${cart.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
