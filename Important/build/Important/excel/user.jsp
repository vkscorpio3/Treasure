<%-- 
    Document   : user
    Created on : Jan 7, 2009, 8:23:48 AM
    Author     : eswar@vaannila.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details</title>
    </head>
    <body>
        <table cellpadding="3" cellspacing="3" border="1">
            <tr>
                <th>
                    User Name
                </th>
                <th>
                    Email Id
                </th>
                <th>
                    Location
                </th>
            </tr>
            <logic:iterate id="data" name="ExcelForm" property="userList">
                <tr>
                    <td>
                        <bean:write name="data" property="userName" />
                    </td>
                    <td>
                        <bean:write name="data" property="emailId" />
                    </td>
                    <td>
                        <bean:write name="data" property="location" />
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <a href="exportUser.jsp" >Excel</a>
    </body>
</html>
