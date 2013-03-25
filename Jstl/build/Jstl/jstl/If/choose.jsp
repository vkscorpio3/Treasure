

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Using Choose,Otherwise and When</title>
  </head>

  <body>
    <c:if test="${pageContext.request.method=='POST'}">You entered:

    <c:choose>
      <c:when test="${param.enter=='1'}">One
      <br />
      </c:when>

      <c:when test="${param.enter=='2'}">Two
      <br />
      </c:when>

      <c:when test="${param.enter=='3'}">Three
      <br />
      </c:when>

      <c:when test="${param.enter=='4'}">Four
      <br />
      </c:when>

      <c:when test="${param.enter=='5'}">Five
      <br />
      </c:when>

      <c:otherwise>
        <c:out value="${param.enter}" />

        <br />
      </c:otherwise>
    </c:choose>
    </c:if>

    <form method="post">Enter a number between 1 and 5:
    <input type="text" name="enter" />

    <input type="submit" value="Accept" />

    <br />
    </form>
  </body>
</html>
