

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Page Data Example</title>
  </head>

  <body>
    <h3>&#160;</h3>

    <table border="1" width="539">
      <tr>
        <td colspan="2" width="529" bgcolor="#0000FF">
          <b>
            <font color="#FFFFFF" size="4">HTTP
            Session(pageContext.session.)</font>
          </b>
        </td>
      </tr>

      <tr>
        <td width="210">Creation Time</td>

        <td width="313">&#160;
        <c:out value="${pageContext.session.creationTime}" />
        </td>
      </tr>

      <tr>
        <td width="210">Session ID</td>

        <td width="313">&#160;
        <c:out value="${pageContext.session.id}" />
        </td>
      </tr>

      <tr>
        <td width="210">Last Accessed Time</td>

        <td width="313">&#160;
        <c:out value="${pageContext.session.lastAccessedTime}" />
        </td>
      </tr>

      <tr>
        <td width="210">Max Inactive Interval</td>

        <td width="313">&#160;
        <c:out
        value="${pageContext.session.maxInactiveInterval}" />

        seconds</td>
      </tr>

      <tr>
        <td width="210">You have been on-line for</td>

        <td width="313">&#160;
        <c:out
        value="${(pageContext.session.lastAccessedTime-pageContext.session.creationTime)/1000}" />

        seconds</td>
      </tr>
    </table>

  </body>
</html>
