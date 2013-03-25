<%-- 
    Document   : usertld
    Created on : Oct 25, 2010, 12:30:59 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix="my" uri="/WEB-INF/My" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <%--<my:reverse name="Ganesan"></my:reverse>--%>
        <my:A var1="23" var2="23" name="${param.string}"></my:A>

       
        
    </body>
</html>
