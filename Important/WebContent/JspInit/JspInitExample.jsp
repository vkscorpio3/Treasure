<%-- 
    Document   : JspInitExample
    Created on : Aug 3, 2011, 2:42:24 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! public void jspInit() {
        ServletConfig Sconfig = getServletConfig();
        ServletContext Scontext = getServletContext();
        String pass = Sconfig.getInitParameter("password");
        Scontext.setAttribute("password", pass);
    }%>
        <h1>Hello World!</h1>
        ${password}
    </body>
</html>
