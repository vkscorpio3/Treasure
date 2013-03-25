package newFolder;

<%-- 
    Document   : 5
    Created on : Jul 27, 2011, 12:46:30 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type='text/javascript'>

            function CloseWindow() {
                ww = window.open(window.location, "_self");
                ww.close();
            }
            function close_window() {
                if (confirm("Close Window?")) {
                    close();
                }
            }


        </script>
        <SCRIPT LANGUAGE="JavaScript">
            window.open("mywindow.htm","newwindow","width=725,height=125");
            setTimeout('window.close()',5000);
            </SCRIPT>

    </head>
    <BODY OnLoad='compt=setTimeout("self.close();",5000)'>
        <h1>Hello World!</h1>
        <a href="javascript:self.close()">Close the window</a>
        <input type="button" value="Close" onclick="CloseWindow();" />
        <a href="javascript:close_window();">close</a>
        <a href="#" onClick="window.open('http://www.irt.org','main','width=640,height=480');setTimeout('window.close()',1000)">irt.org</a>



    </body>
</html>
