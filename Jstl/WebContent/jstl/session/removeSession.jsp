<%-- 
    Document   : removeSession
    Created on : Oct 25, 2010, 11:08:17 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:set var="Name" value="ganesanSession" scope="session" />
<c:set var="Name" value="ganesanApplication" scope="application"/>
<c:set var="Name" value="ganesanRequest" scope="request"/>
<c:set var="Name" value="ganesanPage" scope="page"/>



<html>
  <head>
    <title>Chapter 5 - Set a scoped attribute</title>
  </head>
  <body>
    This page sets a session-scoped attribute that is removed
    by <a href="removeAttribute.jsp">this</a> page.
    
    
    <br>
   sessionScope.Name ==<c:out value="${sessionScope.Name}" />     
	<br>
	applicationScope.Name == <c:out value="${applicationScope.Name}" />
	<br>
	requestScope.Name == <c:out value="${requestScope.Name}" />
	<br>
	pageScope.Name == <c:out value="${pageScope.Name}" />
	<br>
    
    
    
  </body>
</html>
