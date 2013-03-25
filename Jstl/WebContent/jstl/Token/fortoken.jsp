<%-- 
    Document   : fortoken
    Created on : Oct 19, 2010, 10:43:32 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:set var="names" value="A:B;C|D" scope="page" />

<html>
  <head>
    <title>forTokens action</title>
  </head> 

  <body>
    <c:forTokens items="${pageScope.names}"
                 delims=":;|"
                 var="currentName"
                 varStatus="status"
      >
      Family member #<c:out value="${status.count}" /> is
        <c:out value="${currentName}" /> <br />
        ${status.count}
    </c:forTokens>



  </body>
</html>