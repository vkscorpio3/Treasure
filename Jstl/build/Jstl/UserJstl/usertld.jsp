<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix="my" uri="/WEB-INF/My" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Define TLD</title>
    </head>
    <body>
        <h1>Hello World!</h1>        
        <my:A var1="${param.var1}" var2="45" name="${param.string}"></my:A>
        
        <br>
        <br>
        <br>
        <br>
         <my:reverse  name="Ganesan"></my:reverse>

       
        
    </body>
</html>
