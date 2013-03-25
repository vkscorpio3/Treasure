<%-- 
    Document   : foreach
    Created on : Jul 19, 2011, 6:13:24 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/x" prefix="x" %>
<html>
<head>
    <title>For Each Examples</title>
</head>

<body>
    <c:import var="file" url="students.xml" />

    <x:parse var="doc" xml="${file}" />

    <table border="1">
        <tr>
            <th>First</th>

            <th>Last</th>

            <th>Points</th>

            <th>Letter</th>
        </tr>

        <x:forEach var="student" select="$doc/students/student">
            <tr>
                <td>
                    <x:out select="name/first" />
                </td>

                <td>
                    <x:out select="name/last" />
                </td>

                <td>
                    <x:out select="grade/points" />
                </td>

                <td>
                    <x:out select="grade/letter" />
                </td>
            </tr>
        </x:forEach>
    </table>
</body>
