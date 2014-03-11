

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c-rt" %>
<c:if test="${pageContext.request.method=='POST'}">
    <%
        Cookie mycookie = new Cookie("login", request.getParameter("uid"));
        mycookie.setMaxAge(0x7ffffff);
        response.addCookie(mycookie);
    %>
    <c:redirect url="main.jsp">
        <c:param name="uid" value="${param.uid}" />
    </c:redirect>
</c:if>

<html>
    <head>
        <title>Simple Chat with Cookie</title>
    </head>

    <body>

        <c-rt:forEach var="aCookie" items="<%=request.getCookies()%>">
            <c:if test="${aCookie.name=='login'}">
                <c:set var="uid" value="${aCookie.value}"/>
            </c:if>
        </c-rt:forEach>


        <form method="post">
            <table id="AutoNumber1">
                <tbody>
                    <tr>
                        <td width="100%" colspan="2">
                            <p align="center">
                                <b>
                                    <font size="4" >Chat Login</font>
                                </b>
                            </p>
                        </td>
                    </tr>

                    <tr>
                        <td width="23%">User ID</td>

                        <td width="77%">
                            <input type="text" name="uid" value="<c:out value="${uid}"/>" size="20" />
                        </td>
                    </tr>

                    <tr>
                        <td width="100%" colspan="2">
                            <p align="center">
                                <input type="submit" value="Submit"
                                       name="action" />

                                <input type="reset" value="Reset" />
                            </p>
                        </td>
                    </tr>
                </tbody>
            </table>

            <P>&#160;</p>
        </form>

        <P>
            <i>Note: You may use any User ID you wish</i>
        </p>
    </body>
</html>