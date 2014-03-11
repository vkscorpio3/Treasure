package newFolder;

<%-- 
    Document   : 6
    Created on : Jul 27, 2011, 2:00:06 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!--
This file retrieved from the JS-Examples archives
http://www.js-examples.com
1000s of free ready to use scripts, tutorials, forums.
Author: Xavier - 0
-->


</head>
<body>

<script type="text/javascript">
var x;
var myWin;
function wopen(){
  x = window.open("URL");

  window.name = 'myWin'
  
};
function wclose(wname){
  if(wname)
    wname.close();
};
</script>
<a href="#" onclick="wopen();">open 1</a>
<a href="#" onclick="wclose(x);">close 1</a><br>
<a href="URL" target="yz">open 2</a>
<a href="#" onclick="wclose(yz);">close 2</a>
</body>
</html>

