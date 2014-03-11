<%-- 
    Document   : example1
    Created on : Aug 2, 2011, 11:12:56 AM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource var="dataSource" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/Hibernate" user="postgres" password="Barnas@123"
                   />

<%--<sql:setDataSource var="dataSource" dataSource="jdbc/post"/>--%>
<%--<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://192.168.0.18:3306/tnau" user="barnas" password="ZXCVBNM@123"  scope="session"
/>--%>
<html>
    <head>
        <title>SQL Tag Out Examples</title>
    </head>

    <body>

        <sql:query var = "users" dataSource="${dataSource}">
            SELECT id, "name", salary, start_date, city, region FROM employee;
        </sql:query>

        <table border=1>
            <c:forEach var="row" items="${users.rows}">
                <tr>
                    <td><c:out value="${row.id}"/></td>
                    <td><c:out value="${row.name}"/></td>
                    <td><c:out value="${row.salary}"/></td>
                    <td><c:out value="${row.start_date}"/></td>
                    <td><c:out value="${row.city}"/></td>
                    <td><c:out value="${row.region}"/></td>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>


