<%-- 
    Document   : createURL
    Created on : Oct 25, 2010, 11:15:33 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  <head>
    <title>the c:url action (3)</title>
  </head>
  <body>
    <h3>List of query string parameters:</h3>
    <ul>
        ${genderParam}
      <c:forEach items="${param}" var="currentParam">
       
          <c:out value="${currentParam}" />
      </c:forEach>
    </ul>
 </body>
</html>