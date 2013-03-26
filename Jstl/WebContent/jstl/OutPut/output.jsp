
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Out Examples</title>
  </head>
<h3>${pageContext.request.requestURI}</h3>
  <body>
  <h3>Out Example</h3>

  <b>
    <c:out value="${param.color}" />
  </b>


  10 * 3 =
  <c:out value="${10*3}"/>

<a href="<c:out value="${pageContext.request.requestURI}"/>?color=red">red</a>

  <br />

  <a href="<c:out value="${pageContext.request.requestURI}"/>?color=blue">blue</a>

  <br />
  1 + 2 + 3 = <c:out value="${1 + 2 + 3}" />

  </body>
</html>


