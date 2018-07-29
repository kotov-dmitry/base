<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Order</title>

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

<h1>Add a Order</h1>

<c:url var="addAction" value="/orders/add"/>

<form:form action="${addAction}" commandName="order">
    <table>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="Firstname"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondName">
                    <spring:message text="Surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="Lastname"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phoneNumber">
                    <spring:message text="Phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phoneNumber"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="bookId">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="bookId" readonly="true" size="8" disabled="true"/>
                <form:hidden path="bookId"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Add Order"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
