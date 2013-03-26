<%-- 
    Document   : catchexception
    Created on : Oct 20, 2010, 10:31:44 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Catch an Exception</title>
  </head>
  <c:set var="test" value="Hello World" scope="application" />
  <body>
    <c:catch var="e">
    <c:set var="x" value="10" scope="page" />
    <c:set var="y" value="five" scope="page" />
    x divided by y is
    <c:out value="${x/y}" />    
    </c:catch>
    
    
    
    
    <br />
    <c:if test="${e!=null}">The caught exception is:
    <c:out value="${e}" />
    <br />
    </c:if>
    <c:if test="${e==null}">No exception was thrown
    <br />
    </c:if>
    
    
    
    
  </body>
</html>
