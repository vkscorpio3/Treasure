<%-- 
    Document   : displayURL
    Created on : Oct 25, 2010, 11:17:05 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:url value="displayValues.jsp" var="displayURL">
  <c:param name="nameParam"   value="${param.name}" />
  <c:param name="ageParam"    value="${param.age}" />
  <c:param name="genderParam" value="${param.gender}" />
</c:url>

<html>
  <head>
    <title>the c:url action (2)</title>
  </head>
  <body>
    This page receives the values you specified, and creates a URL that contains
    them.
    <p />
    The generated URL is <c:out value="${displayURL}" />. <p/>
    Click <a href='<c:out value="${displayURL}" />'>here</a> to view the it.
  </body>
</html>