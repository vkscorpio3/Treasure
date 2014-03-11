

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
    <head>
        <title>EL Expression Examples</title>
    </head>
    <body>
        <h1>EL Expression Examples</h1>

        <h2>Arithmetic Operators in Expressions</h2>
        <c:set var="appleCount" value="${1 + 2 * 4 - 6 / 2}"/>


        <c:out value="${appleCount}" />

    </body>
</html>
