<%-- 
    Document   : MapValue
    Created on : Jul 20, 2011, 9:45:50 AM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/x" prefix="x" %>
<html>
    <head>
        <title>Set Examples</title>
    </head>

    <body>
        <c:import var="file" url="students.xml" />

        <x:parse var="doc" xml="${file}" />

        <x:set var="a" select="$doc/students/student/name/first" />

        <x:set var="b"
               select="$doc/students/student[@id=2]/name/first" />

        <x:set var="c"
               select="$doc/students/student[@id=1]/name/first" />

        <table border="1">
            <tr>
                <td>$doc/students/student/name/first</td>

                <td>
                <x:out select="$a" />
            </tr>

            <tr>
                <td>$doc/students/student[@id=2]/name/first</td>

                <td>
                    <x:out select="$b" />
                </td>
            </tr>

            <tr>
                <td>$doc/students/student[@id=1]/name/first</td>

                <td>
                    <x:out select="$c" />
                </td>
            </tr>
        </table>
       
    </body>
</html>
