<%-- 
    Document   : checkbox
    Created on : Oct 20, 2010, 3:07:58 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form method="post" action="checkbox1.jsp">
  <p>Please check adjectives you would
  use to describe this web site's
  customer service:</p>

  <p>Atrocious
  <input type="checkbox" name="feedback" value="atrocious"/></p>

  <p>Loathsome
  <input type="checkbox" name="feedback" value="loathsome"/></p>

  <p>Flagitious
  <input type="checkbox" name="feedback" value="flagitious"/></p>

  <p>Satisfactory
  <input type="checkbox" name="feedback" value="satisfactory"/></p>

  <p><input type="submit" value="Submit" /></p>
</form>
    </body>
</html>
