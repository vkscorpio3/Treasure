
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Remove a scoped attribute</title>
  </head>
  <body>
    The session-scoped attribute called <b>userName</b> had a value
    of  but it is about
    to be removed!<p/>
    
    
    <br>
   sessionScope.Name ==<c:out value="${sessionScope.Name}" />     
	<br>
	applicationScope.Name == <c:out value="${applicationScope.Name}" />
	<br>
	requestScope.Name == <c:out value="${requestScope.Name}" />
	<br>
	pageScope.Name == <c:out value="${pageScope.Name}" />
	<br>
	
	<h2> C:REMOVE </h2>
	
    <c:remove var="Name" scope="session" />
	<c:remove var="Name" scope="request" />
	<c:remove var="Name" scope="application" />
	<c:remove var="Name" scope="page" />
	
	<br>
     
    <h2> The value is now</h2>
    
  <br>
   sessionScope.Name ==<c:out value="${sessionScope.Name}" />     
	<br>
	applicationScope.Name == <c:out value="${applicationScope.Name}" />
	<br>
	requestScope.Name == <c:out value="${requestScope.Name}" />
	<br>
	pageScope.Name == <c:out value="${pageScope.Name}" />
	<br>
    
    - NYA ha ha ha ha!
  </body>
</html>
