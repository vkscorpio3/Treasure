<%-- 
    Document   : checkbox1.jsp
    Created on : Oct 20, 2010, 3:08:41 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:choose>
 <c:when test="${not empty paramValues.feedback}">
  You described our customer service as
  <ul>
  <c:forEach items="${paramValues.feedback}" var="adj">
    <li><c:out value="${adj}"/></li>
  </c:forEach>
  </ul>
 </c:when>
 <c:otherwise>
  You didn't choose any feedback checkboxes.
 </c:otherwise>
</c:choose>
