<%-- 
    Document   : foreachexample
    Created on : Oct 19, 2010, 11:05:19 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<html>
    <head>
        <title>Count to 10 Example(using JSTL)</title>
    </head>

    <body>
        <c:forEach var="i" begin="1" end="10" step="1">
            <c:out value="${i}" />
            <br>
            Decrement- -<c:out value="${11-i}" />

            <br />
        </c:forEach>


        <br>
        <br>
        <br>
        <br>

        <c:set var="names" value="Peter, Pat, Mark, Tracy,Ganesh,Ram" scope="page" />

        <c:forEach items="${pageScope.names}"
                   var="currentName"
                   varStatus="status"
                   begin="0"
                   end="3"
                   step="1"
                   >
            Family member #<c:out value="${status.count}" /> is
            <c:out value="${currentName}" /> <br />
        </c:forEach>




        <br>
        <br>
        <br>
        <br>


        <%
        String[] bikes = {"ABike", "BBile", "CBike"};
        %>

        <c-rt:forEach var="bike" items="<%= bikes %>">
            <LI><c:out value="${bike}" />
        </c-rt:forEach>




        <br>
        <br>
        <br>
        <br>


        <%!    String[] names = {"A", "B", "C", "D"};
    int[] ages = {29, 8, 6, 5};
        %>


        <c-rt:forEach var="person" items="<%= names %>">

            <c:out value="${person}"  />
            <c:out value="${ages[2]}" />

        </c-rt:forEach>

        <br>
        <br>

        <br>
        <br>

    </body>
</html>
