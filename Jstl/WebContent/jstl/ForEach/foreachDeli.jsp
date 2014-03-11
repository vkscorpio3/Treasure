
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c-rt" %>
<html>
    <head>
        <title>Count to 10 Example(tracking even and odd)</title>
    </head>

    <body>
        <c:set var="days" value="A,B,C,D,E,F,G" />

        <table border="0">
            <c:forEach var="i" items="${days}" varStatus="status">
                <jsp:useBean id="status"
                             type="javax.servlet.jsp.jstl.core.LoopTagStatus" />

                <c-rt:choose>
                    <c-rt:when test="<%=status.getCount()%2==0%>">
                        <c:set var="color" value="#cccccc" />
                    </c-rt:when>

                    <c-rt:otherwise>
                        <c:set var="color" value="#dddddd" />
                    </c-rt:otherwise>
                </c-rt:choose>

                <tr>
                    <td width="200" bgcolor="<c:out value="${color}"/>">
                        <c:out value="${i}" />
                    </td>
                </tr>
            </c:forEach>
        </table>


        <br>
        <br>



        <table border="0">
            <c:forEach var="i" begin="1" end="10" varStatus="status1">
                <jsp:useBean id="status1" type="javax.servlet.jsp.jstl.core.LoopTagStatus" />


                <c-rt:choose>
                    <c-rt:when test="<%=status1.getCount()%2==0%>">
                        <c:set var="color" value="orange" />
                    </c-rt:when>

                    <c-rt:otherwise>
                        <c:set var="color" value="green" />
                    </c-rt:otherwise>
                </c-rt:choose>

                <tr>
                    <td width="200" bgcolor="<c:out value="${color}"/>">
                        <c:out value="${i}" />
                    </td>
                </tr>
            </c:forEach>
        </table>



<br>
    <br>




        <table border="0">
            <c:forEach var="i" begin="1" end="10" varStatus="statusR">
 <jsp:useBean id="statusR" type="javax.servlet.jsp.jstl.core.LoopTagStatus" />
                <c:choose>
                    <c:when test="${statusR}">
                        <c:set var="color" value="orange" />
                    </c:when>

                    <c:otherwise>
                        <c:set var="color" value="green" />
                    </c:otherwise>
                </c:choose>

                <tr>
                    <td width="200" bgcolor="<c:out value="${color}"/>">
                        <c:out value="${i}" />
                    </td>
                </tr>
            </c:forEach>
        </table>
































    </body>

</html>