

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<html>
  <head>
    <title>Import a Page</title>
  </head>

  <body>
    <form method="POST">
      <table>
        <tr>
          <td width="100%" colspan="2">
           Import
          </td>
        </tr>

        <tr>
          <td width="47%">Enter a site to import:</td>

          <td width="53%">
            <input type="text" name="url" size="20"
              value="http://www.java2s.com"/>
          </td>
        </tr>

        <tr>
          <td width="100%" colspan="2">
            <p align="center">
              <input type="submit" value="Submit" name="submit" />

              <input type="reset" value="Reset" name="reset" />
            </p>
          </td>
        </tr>
      </table>

      <P>&#160;</p>
    </form>

    <c:if test="${pageContext.request.method=='POST'}">
      <hr>
      <c:import url="${param.url}"/>
    </c:if>
  </body>
</html>
