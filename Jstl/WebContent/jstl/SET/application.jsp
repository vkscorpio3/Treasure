<%-- 
    Document   : application
    Created on : Oct 20, 2010, 11:03:18 AM
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
    <c:set var="test" value="Application Level Value" scope="application" />
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
