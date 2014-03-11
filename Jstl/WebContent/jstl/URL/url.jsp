<%-- 
    Document   : url
    Created on : Oct 25, 2010, 11:15:14 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:set var="originalURL" value="http://localhost:8080/chapter05/core/url/url.jsp"/>

<html>
  <head>
    <title>the c:url action </title>
  </head>
  <body>
    This page takes 3 values that you specify, and forwards them to another JSP.
    That JSP will create a URL to another page, that then extracts the
    parameters and displays them.
    <p />
      <form action="createURL.jsp" method="post">
        <table>
          <tr><td>Enter name:</td>
              <td><input type="text" name="name"   /></td></tr>
          <tr><td>Enter age:</td>
              <td><input type="text" name="age"    /></td></tr>
          <tr><td>Enter gender:</td >
              <td><input type="text" name="gender" /></td></tr>
        </table>
        <input type="submit" value="Submit details" />
      </form>
  </body>
</html>
