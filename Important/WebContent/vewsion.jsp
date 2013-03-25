
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Working with server: <%= application.getServerInfo()%><br>
        Servlet Specification: <%= application.getMajorVersion()%>.<%= application.getMinorVersion()%> <br>
        JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion()%><br>
            JSP Engine: <%= JspFactory.getDefaultFactory().getEngineInfo()%><br>
                JSP Factory: <%= JspFactory.getDefaultFactory()%><br>
    </body>
</html>
