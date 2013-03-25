<%-- 
    Document   : removeSession
    Created on : Oct 25, 2010, 11:08:17 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:set var="userName" value="Mark" scope="session" />

<html>
  <head>
    <title>Chapter 5 - Set a scoped attribute</title>
  </head>
  <body>
    This page sets a session-scoped attribute that is removed
    by <a href="removeAttribute.jsp">this</a> page.
  </body>
</html>
