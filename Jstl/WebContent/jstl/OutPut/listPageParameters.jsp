<%-- 
    Document   : listPageParameters
    Created on : Oct 15, 2010, 4:27:18 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
  <head><title> Display details</title></head>
  <body>
    <h1>Your details (or, the details that you entered!)</h1>
    <table>
      <tr><td>First name</td>
          <td><c:out value="${param.firstName}" /></td>
      </tr>
      <tr><td>Last name</td>
          <td><c:out value="${param.lastName}" /></td>
      </tr>
      <tr><td>Age</td>
          <td><c:out value="${param.age}" /></td>
      </tr>
      <%-- The following two values are not passed from the HTML form
           and are present to show the syntax for specifying default
           values --%>
      <tr><td>Partner's name</td>
          <td><c:out value="${param.partnerName}" default="Unknown name" /></td>
      </tr>
      <tr><td>Partner's age</td>
          <td><c:out value="${param.partnerAge}">
                Unknown age
              </c:out>
          </td>
      </tr>
    </table>
  </body>
</html>
