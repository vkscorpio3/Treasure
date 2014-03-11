<%-- 
    Document   : header
    Created on : Oct 25, 2010, 10:05:17 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
  <head>
    <title>List HTTP headers</title>
  </head>
  <body>
    This page has the following HTTP headers:<br />
    <ol>
      <%-- 'param' is an implicit object. It is a Map that maps a 'key'
           (the parameter name) to a 'value' --%>
      <c:forEach var="nextHeader" items="${header}">
        <li> <c:out value="${nextHeader.key}" /> = <c:out value="${nextHeader.value}" />
      </c:forEach>
    </ol>
  </body>
</html>
