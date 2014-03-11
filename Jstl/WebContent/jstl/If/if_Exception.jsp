
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%
  int i= (int) (Math.random() * 10);
  pageContext.setAttribute("signalStrength", new Integer(i), PageContext.PAGE_SCOPE);
%>

<html>
  <head>
    <title>The c:catch action</title>
  </head>
  <body>
    <c:if test="${pageScope.signalStrength < 5}">
        
      <c:set var="signalFailure" value="true" scope="page" />
    </c:if>

    <c:choose>
      <c:when test="${pageScope.signalFailure == true}">
        <h3>Exception!</h3>
        Refresh the page in your web browser to try again.
      </c:when>
      <c:otherwise>
        <h3>No Exception.</h3>
        Refresh the page in your web browser to make another call.
      </c:otherwise>
    </c:choose>
  </body>
</html>
