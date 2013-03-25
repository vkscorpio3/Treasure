<%-- 
    Document   : if_logical
    Created on : Oct 15, 2010, 5:32:48 PM
    Author     : root
--%>

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

<h2>Logical Operators</h2>

<c:set var="guess" value="1"/>
<b>Your guess is </b>
<c:out value="${guess}"/>

<br/>

<c:if test="${(guess >= 10)  && (guess <= 20)}">
   <b>You're in range!</b><br/>
</c:if>
<c:if test="${(guess < 10)  || (guess > 20)}">
   <b>Try again!</b><br/>
</c:if>

<br>
     <c:if test="true">Hello world!</c:if>

</body>
</html>
