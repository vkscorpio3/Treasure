<%-- 
    Document   : header
    Created on : Oct 25, 2010, 10:15:25 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<table width="100%">
  <tr>
    <td align="left" bgcolor="#888888">
      <big><font color="#FFFFFF">
        <c:out value="${param.title}"/>
      </font></big>
    </td>
    <td align="right">
      <small>
        Import example application
      </small>
    </td>
  </tr>
</table>
