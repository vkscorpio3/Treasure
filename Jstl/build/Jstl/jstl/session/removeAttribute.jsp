<%-- 
    Document   : removeAttribute
    Created on : Oct 25, 2010, 11:08:30 AM
    Author     : root
--%>

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
    of <b> <c:out value="${sessionScope.userName}" /> </b>, but it is about
    to be removed!<p/>

    <c:remove var="userName" scope="session" />

    The value is now "<c:out value="${sessionScope.userName}" />" - NYA ha ha ha ha!
  </body>
</html>
