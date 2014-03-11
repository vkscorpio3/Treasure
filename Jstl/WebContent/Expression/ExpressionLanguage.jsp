
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expression Language</title>
    </head>
    <body>
        
		<h2>String []</h2>${musicList}
        <br>
		<h2>String [1]</h2>${musicList[1]}
        <br>
        <br>
		<h2>ArrayList []</h2>${favoriteFood}
        <br>
        <h2>The Map is by using "[key]"</h2> ${map["1"]}
        <br>
        <h2>The Map is by using "." key </h2> ${map.key}
        <br>
        <h2>The Map is by using Long data type</h2>   ${map1[22]}
        <br>
       <h2> This is accessing Bean by bean.variable</h2>${bean.name}
        <br>
        <h2>This is Context Init Parameter (happened in web.xml) == </h2>  ${initParam.Email}

        <br>
        <h2>This is Cookies</h2> ${cookie.userName.value}
        <br>
        
       
        <h2>This is Normal request.setAttribute() in controller</h2>  ${attribute}
        <br>
        
        




		<h2> Parameter not visible in current page </h2> 
       ${param.subTitle} <!-- This is not have scope in this page  -->


   
        <br>
        <br>
        <jsp:include page="Includesample.jsp">
            <jsp:param name="subTitle" value="its parameter from jsp:param using jsp:include"></jsp:param>
        </jsp:include>
        <br>
        
        
 		      




    </body>
</html>
