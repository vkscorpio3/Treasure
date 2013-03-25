

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Updatable Collections</title>
  </head>

  <body>
    <table border="0">
      <form method="post">
        <tr><td>Parse for Tokens</td></tr>
        <tr>
          <td valign="top">
            <p align="left">Enter a sentence:
            <br />
            <input width="20" maxwidth="100" name="text" size="100" />
            <br />&#160;</p>
          </td>
        </tr>

        <tr>
          <td valign="top">
            <p align="center">
              <input type="submit" name="parse" value="Parse" />
            </p>
          </td>
        </tr>
      </form>
    </table>

    <c:if test="${pageContext.request.method=='POST'}">
      <table border="1">
        <c:set var="i" value="1" />
        <c:forTokens items="${param.text}" var="word" delims=" ,.?!">
          <c:set var="i" value="${i}" />

          <tr>
            <td>
              <b>Word
              <c:out value="${i}" />
              </b>
            </td>

            <td>
              <c:out value="${word}" />
            </td>
          </tr>
        </c:forTokens>
      </table>
    </c:if>
  </body>
</html>
