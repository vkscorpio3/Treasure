
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c-rt" %>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>



<c:if test="${pageContext.request.method=='POST'}">
  <c:if test="${param.reg!=null}">
    <c:redirect url="http://www.java2s.com" />
  </c:if>

  <h3 color="red">Sorry, we have no one registered with that
    name.</h3>
</c:if>


<html>
  <head>
    <title>Welcome</title>
  </head>

  <body>
    Please login.<br>
    <form method="POST">
      <table>
        <tr>
          <td width="100%" colspan="2" bgcolor="#0000FF">
            <p align="center">
              <b>
                <font color="#FFFFFF" size="4">Login</font>
              </b>
            </p>
          </td>
        </tr>

        <tr>
          <td width="26%">Login Name</td>

          <td width="74%">
          <input type="text" name="uid" size="20" />

          </td>
        </tr>

        <tr>
          <td width="26%">Password</td>

          <td width="74%">
            <input type="password" name="pwd" size="20" />
          </td>
        </tr>

        <tr>
          <td width="100%" colspan="2">
            <p align="center">
              <input type="submit" value="Login" name="Login" />

              <input type="submit" value="Register" name="reg" />
            </p>
          </td>
        </tr>
      </table>

     
    </form>

  </body>
</html>