
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>If with Body</title>
  </head>

  <body>
    <c:if test="${pageContext.request.method=='POST'}">
      <c:if test="${param.guess=='5'}">You guessed my number!
      <br />

      <br />

      <br />
      </c:if>

      <c:if test="${param.guess!='5'}">You did not guess my number!
      <br />

      <br />

      <br />
      </c:if>
    </c:if>

    <form method="post">Guess what number I am thinking of?
    <input type="text" name="guess" />

    <input type="submit" value="Try!" />

    <br />
    </form>
  </body>
</html>
