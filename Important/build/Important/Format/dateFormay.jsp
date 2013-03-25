<%@ page import="java.util.*,java.text.*;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/Format" prefix="fmt"%>
<html>
    <head>
        <meta http-equiv="refresh" content="3">
        <title>Format Date</title>
    </head>

    <body bgcolor="#6E6E6E">
        <%Date date = new java.util.Date();
        Format formatter;
        System.out.println(date);
        String s;
       formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
        s = formatter.format(date);
        System.out.println(s);
        pageContext.setAttribute("date", date);%>
        
        <c:set var="date" value="${date}" />

        <table bgcolor="#D8D8D8" border="1" width="70%">
            <tr>
                <td width="100%" colspan="2" bgcolor="#1C1C1C">
                    <p align="center"><b> <font color="#D8D8D8" size="4">Formatting: <fmt:formatDate
                                value="${date}" type="both" timeStyle="long" dateStyle="long" /> </font>
                    </b></p>
                </td>
            </tr>

            <tr>
                <td width="51%">Attribute : type="date"</td>

                <td width="49%"><fmt:formatDate type="date" value="${date}" /></td>
            </tr>
            <tr>
                <td width="51%">Attribute : type="time"</td>

                <td width="49%"><fmt:formatDate type="time" value="${date}" /></td>
            </tr>

            <tr>
                <td width="51%">Attribute : type="both"</td>

                <td width="49%"><fmt:formatDate type="both" value="${date}" /></td>
            </tr>

            <tr>
                <td width="51%">Attribute : type="both" dateStyle="default"
                timeStyle="default"</td>

                <td width="49%"><fmt:formatDate type="both" dateStyle="default"
                                                timeStyle="default" value="${date}" /></td>
            </tr>

            <tr>
                <td width="51%">Attribute : type="short" dateStyle="default"
                timeStyle="short"</td>

                <td width="49%"><fmt:formatDate type="both" dateStyle="short"
                                                timeStyle="short" value="${date}" /></td>
            </tr>

            <tr>
                <td width="51%">Attribute : type="both" dateStyle="medium"
                timeStyle="medium"</td>

                <td width="49%"><fmt:formatDate type="both" dateStyle="medium"
                                                timeStyle="medium" value="${date}" /></td>
            </tr>

            <tr>
                <td width="51%">Attribute : type="both" dateStyle="long"
                timeStyle="long"</td>

                <td width="49%"><fmt:formatDate type="both" dateStyle="long"
                                                timeStyle="long" value="${date}" /></td>
            </tr>

            <tr>
                <td width="51%">Attribute : type="both" dateStyle="full"
                timeStyle="full"</td>

                <td width="49%"><fmt:formatDate type="both" dateStyle="full"
                                                timeStyle="full" value="${date}" /></td>
            </tr>

            <tr>
                <td width="51%">Attribute : pattern="yyyy-MM-dd"</td>

                <td width="49%"><fmt:formatDate pattern="yyyy-MM-dd" value="${date}" />
                </td>
            </tr>
            <tr>
                <td width="51%">Attribute : pattern="yyyy-MM-dd hh:mm:ss"</td>

                <td width="49%"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
                                                value="${date}" /></td>
            </tr>
        </table>
    </body>
</html>
