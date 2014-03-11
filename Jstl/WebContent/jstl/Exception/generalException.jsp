
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Throw an Exception</title>
  </head>

  <body>10 divided by 0 is
  <c:out value="${10/0}" />

  <br />

<br>
    <br>
        <br>
  <br>




      <c:catch var="signalException">
      <%
        int i= (int) (Math.random() * 10);

        if (i < 5 )
          throw new NullPointerException(); %>
    </c:catch>


    <c:choose>
      <c:when test="${signalException != null}">

        Exception!!!
      </c:when>
      <c:otherwise>
        No Exception!!!
      </c:otherwise>
    </c:choose>







<br>
    <br>
        <br>
            <br>
                <br>


<body>
    <c:catch var="e">
    <c:set var="x" value="10" scope="page" />

    <c:set var="y" value="five" scope="page" />

    x divided by y is
    <c:out value="${x/y}" />

    <br />
    </c:catch>

    <br />
    <c:if test="${e!=null}">The caught exception is:
    <c:out value="${e}" />

    <br />
    </c:if>

    <c:if test="${e==null}">No exception was thrown
    <br />
    </c:if>


<br>
    <br><br><br>
        <br>





<c:catch var="e">
    <c:set var="x" value="10" scope="page" />

    <c:set var="y" value="five" scope="page" />

    10 divided by 0 is
    <c:out value="${10/0}" />

    <br />
    </c:catch>

    <c:if test="${e!=null}">The caught exception is:
    <c:out value="${e}" />

    <br />
    </c:if>

    <c:if test="${e==null}">No exception was thrown
    <br />
    </c:if>

<br>
    <br>
        <br>
            <br>
                <br>





  </body>
</html>
