<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Count to 10 Example(using JSTL)</title>
  </head>

  <body>
    <c:forEach var="i" begin="1" end="10" step="1">
    <h3>HI im in Loop</h3>

      <br/>
    </c:forEach>
  </body>
</html>

