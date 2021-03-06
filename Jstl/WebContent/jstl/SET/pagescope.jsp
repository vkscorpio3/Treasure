<%-- 
    Document   : scope
    Created on : Oct 20, 2010, 11:01:26 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Set in Scope Examples</title>
  </head>

  <body>
    <c:set var="test" value="Page Level Value" scope="page" />
        <c:set var="test" value="Page Level Value1" scope="request" />
        <c:set var="test" value="Page Level Value2" scope="session" />
    
    <table border="1">
    <tr>
        <td>
          <b>Default Level</b>
        </td>

        <td>
          <c:out value="${test}" />
        </td>
      </tr>

  <tr>
        <td>
          <b>Default using c tag</b>
        </td>

        <td>
          <c:out value="${test}" />
        </td>
      </tr>

      
      <tr>
        <td>
          <b>Page Level</b>
        </td>

        <td>
          <c:out value="${pageScope.test}" />
        </td>
      </tr>

      <tr>
        <td>
          <b>Request Level</b>
        </td>

        <td>
          <c:out value="${requestScope.test}" />
        </td>
      </tr>

      <tr>
        <td>
          <b>Session Level</b>
        </td>

        <td>
          <c:out value="${sessionScope.test}" />
        </td>
      </tr>

      <tr>
        <td>
          <b>Application Level</b>
        </td>

        <td>
          <c:out value="${applicationScope.test}" />
        </td>
      </tr>
    </table>
  </body>
</html>
