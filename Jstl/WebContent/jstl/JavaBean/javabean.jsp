
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c-rt" %>
<html>
  <head>
    <title>If Caseless</title>
  </head>

  <body>
    <c:set var="str" value="jStL" />

    <jsp:useBean id="str" type="java.lang.String" />

    <c-rt:if test='<%=str.equalsIgnoreCase("JSTL")%>'> They are
    equal</c-rt:if>
  </body>
</html>
