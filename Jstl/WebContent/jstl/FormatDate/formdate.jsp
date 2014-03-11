<%-- 
    Document   : formdate
    Created on : Oct 20, 2010, 4:44:52 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c-rt" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
  <head>
    <title>Format Date</title>
  </head>

  <body>
                <c-rt:set var="now" value="<%=new java.util.Date()%>" />
                <fmt:formatDate type="time" value="${now}" />


<c-rt:set var="now" value="<%=new java.util.Date()%>" />
    <fmt:formatNumber type="number" value="123.123" />

  </body>
</html>
