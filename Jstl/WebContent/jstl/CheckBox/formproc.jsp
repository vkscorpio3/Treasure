<%-- 
    Document   : formproc
    Created on : Oct 20, 2010, 4:01:24 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
<title>EL Implicit Object Example Form Processor</title>
</head>
<body>
<h1>EL Implicit Object Example Form processor</h1>

<b>Shape of cake selected:</b>
<c:out value="${param.shape}"/>

 <br/>
<b>Toppings selected:</b>




<c:forEach var="aTopping" items="${paramValues.topping}" varStatus="status">
    ${status}
 <c:out value="${aTopping}"/>
</c:forEach>
<br/>


<small><a href="select.jsp">back to form</a></small>
</body>
</html>
