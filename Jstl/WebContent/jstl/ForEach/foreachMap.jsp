

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%

 
  Map<String, String> countryCapitalList = new HashMap<String, String>();
  countryCapitalList.put("United States", "Washington DC");
  countryCapitalList.put("India", "Delhi");
  countryCapitalList.put("Germany", "Berlin");
  countryCapitalList.put("France", "Paris");
  countryCapitalList.put("Italy", "Rome");
           
  

request.setAttribute("capitalList", countryCapitalList);%>

<html>
  <head>
    <title>Search result: Authors</title>
  </head>
  <body bgcolor="white">
    Here are all authors matching your search critera:
    <table>
    <thead><tr>
      <th>Name</th>
      <th>Capital</th></tr>
      </thead>
      <c:forEach var="current" items="${capitalList}" >
        <tr>
          <td>${current.key}<td>
          
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
