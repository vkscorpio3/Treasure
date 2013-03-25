<%-- 
    Document   : ImportPagwithParameterPassing
    Created on : Oct 25, 2010, 10:14:45 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<body>
<c:import url="header.jsp">
  <c:param name="title" value="Welcome to Page 1"/>
</c:import>

<h4>Page 1 information</h4>

We're pleased to introduce <b>Page 1</b>, our newest,
most cost-effective product.

</body>
</html>