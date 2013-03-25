<%-- 
    Document   : scopeexample
    Created on : Oct 20, 2010, 10:30:15 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Scope Example</title>
  </head>

  <body>
    



<c:set var="scopeVarPage" value="Page Value" scope="page" />

<c:set var="scopeVarRequest" value="Request Value"
scope="request" />

<c:set var="scopeVarSession" value="Session Value"
scope="session" />

<c:set var="scopeVarApplication" value="Application Value"
scope="application" />


    <table border="1">
      <tr>
        <th>Scoped Variable</th>

        <th>Current Value</th>
      </tr>

      <tr>
        <td>
        <b>Page Scope</b>

        (scopeVarPage)</td>

        <td>&#160;
        <c:out value="${scopeVarPage}" />
        </td>
      </tr>

      <tr>
        <td>
        <b>Request Scope</b>

        (scopeVarRequest)</td>

        <td>&#160;
        <c:out value="${scopeVarRequest}" />
        </td>
      </tr>

      <tr>
        <td>
        <b>Session Scope</b>

        (scopeVarSession)</td>

        <td>&#160;
        <c:out value="${scopeVarSession}" />
        </td>
      </tr>

      <tr>
        <td>
        <b>Application Scope</b>

        (applicationVarPage)</td>

        <td>&#160;
        <c:out value="${scopeVarApplication}" />
        </td>
      </tr>
    </table>
  </body>
</html>
