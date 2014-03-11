

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Set Examples</title>
  </head>

  <body>
  <h3>Set With No Body</h3>

  <c:set var="str" value="Hello World" />

  str =
  <c:out value="${str}" />

  <br />
<h3>Set With Body</h3>



<%--   <c:set var="str">Hello, Again World</c:set> --%>

  str =
  <c:out value="${str}" />

  <br />

  </body>
</html>
