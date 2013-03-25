

<%-- 
    Document   : ExpressionLanguage
    Created on : Sep 20, 2010, 10:05:06 AM
    Author     : root
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
        <h1>Hello World!</h1>
        <!--hiiiiii  -->

${musicList}
        <br>
       ${musicList[1]}

        <br>
        <br>

     ${favoriteFood}
        <br>
        The Map is by using "[ ]" ${map["1"]}  -----
        The Map is by using "." ${map.gg}
        <br>
        The Map is by using Long data type     ${map1[22]}
        <br>
        This is Bean ${bean.name}
        <br>
        This is Context Init Parameter ==  ${initParam.Email}

        <br>
        This is Cookies ${ cookie.userName.value}
        <br>
        This is Normal ${normal}

    ${param.subTitle} <!-- This is not have scope in this page  -->

        <br>
        <br>
        <br>
        <jsp:include page="sample.jsp">
            <jsp:param name="subTitle" value="Hi This is JSP Param and it has sample.Jsp"></jsp:param>
        </jsp:include>
        <br>
 
      




    </body>
</html>
