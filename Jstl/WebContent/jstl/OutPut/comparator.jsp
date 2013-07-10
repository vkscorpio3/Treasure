
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html>
<head>
<title>EL Expression Examples</title>
</head>
<body>
<h1>EL Expression Examples</h1>

<h2>Logical Operators</h2>



<h2>Comparison Operators</h2>

<!-- 4 > '3' -->
<%-- <c:out value="${4 > '3'}"/> --%>
<!-- <br/> -->
<!-- '4' > 3 -->
<%-- <c:out value="${'4' > 3}"/> --%>
<!-- <br/> -->

<!-- '4' > '3' -->
<%-- <c:out value="${'4' > '3'}"/> --%>
<!-- <br/> -->



4 >= 3
<c:out value="${4 >= 3}"/>
<br/>
4 <= 3
<c:out value="${4 < 3}"/>
<br/>
4 == '4'
<c:out value="${4 == 4}"/>
<br/>



<body>
<h1>EL Expression Examples</h1>

<h2>Arithmetic Operators in Expressions</h2>

<h2>Modulo</h2>

 <c:out value="${2003 mod 8}" />
 <br><br><br>
 
<c:out value="${2003 % 8}" />

<h2>Divide</h2>
<c:out value="${23/54}" />
<br>


  
  <c:out value="${2003 / 8}" />
  
   

</body>
</html>
