<%-- 
    Document   : remove
    Created on : Oct 20, 2010, 10:48:36 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Set Examples</title>
  </head>

  <body>
  <h3>Remove Example</h3>

  <c:set var="test" value="Hello World" scope="application" />

  The value in the variable test before remove is
  <c:out value="${test}" />

  <br />

  <c:remove var="test" scope="application" />

  The value in the variable test after remove is
  <c:out value="${test}" />





<br>
  <br>
  <c:set var="names" value="A B C, D" scope="page" />




    <c:forEach items="${names}"
               var="currentName"
               varStatus="status"
    >
      Family member #<c:out value="${status.count}" /> is
        <c:out value="${currentName}" /> <br />
    </c:forEach>

  </body>
</html>