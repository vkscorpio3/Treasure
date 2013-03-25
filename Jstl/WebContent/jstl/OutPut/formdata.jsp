<%-- 
    Document   : formdata
    Created on : Oct 15, 2010, 4:26:53 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head><title>Create Person</title></head>
  <body>
    <h1>Enter your details</h1>
    <form action="listPageParameters.jsp" method="post">
      <table>
        <tr><td>First name:</td> <td><input type="text" name="firstName" /></td></tr>
        <tr><td>Last name:</td>  <td><input type="text" name="lastName"  /></td></tr>
        <tr><td>Age:</td>        <td><input type="text" name="age"       /></td></tr>
      </table>
      <input type="submit" value="Submit details" />
    </form>
  </body>
</html>
