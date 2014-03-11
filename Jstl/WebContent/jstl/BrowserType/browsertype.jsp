<%-- 
    Document   : browsertype
    Created on : Oct 25, 2010, 11:28:05 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<html>
  <head>
    <title>Browser Check</title>
  </head>
  <body bgcolor="white">

    <% String userAgent = request.getHeader("User-Agent"); %>
    <c_rt:choose>
      <c_rt:when test='<%= userAgent.indexOf("MSIE") != -1 %>' >
         You're using Internet Explorer.
      </c_rt:when>
      <c_rt:when test='<%= userAgent.indexOf("Mozilla") != 1 %>' >
         You're probably using Netscape.
      </c_rt:when>
      <c_rt:otherwise>
         You're using a browser I don't know about.
      </c_rt:otherwise>
    </c_rt:choose>

<br>
    <br>
        <br><br>


<c-rt:choose>
      <c-rt:when test="<%=request.getHeader("User-Agent").indexOf("MSIE")!=-1%>">
      You are using Internet Explorer
      </c-rt:when>
      <c-rt:otherwise>
      You are using Netscape, or some other browser....
      </c-rt:otherwise>
    </c-rt:choose>

  </body>
</html>
