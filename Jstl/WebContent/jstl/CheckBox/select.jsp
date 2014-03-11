<%-- 
    Document   : select
    Created on : Oct 20, 2010, 4:00:51 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
<title>EL Implicit Object Example</title>
</head>
<body>
<h1>EL Implicit Object Examples</h1>
<form action="formproc.jsp" method="post">
<table>
<tr>
 <td colspan="2"><h3>Design a Cake</h3></td>
</tr>
<tr>
<td>Cake shape:</td>
<td>
  <select name="shape">
     <option>round</option>
     <option>square</option>
     <option>heart</option>
   </select>
</td>
</tr>
<tr>
<td valign="top">Toppings</td>
<td>
  <input type="checkbox" name="topping" value="choc">Chocolate</input><br/>
  <input type="checkbox" name="topping" value="cane">Candy Cane</input><br/>
  <input type="checkbox" name="topping" value="flower">Flower</input><br/>
</td>

</tr>

<tr>
<td colspan="2">
  <center><input type="submit" value="Send"/></center>
</td>
</tr>
</table>
</form>
</body>
</html>
