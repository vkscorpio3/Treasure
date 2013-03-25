package newFolder;

<%-- 
    Document   : 2
    Created on : Jul 27, 2011, 11:40:51 AM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Untitled Document</title>
        <script language="javascript">
            function spanCount()
            {                
                alert('hi');
                window.opener=self;
                window.close()
            }
        </script>
        <script language="javascript">
            window.onload = spanCount();
        </script>

    </head>

    <body onload="">


    </body>
</html>

