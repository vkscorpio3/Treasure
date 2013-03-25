<%-- 
    Document   : xml
    Created on : Oct 25, 2010, 11:32:46 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jstl/x" prefix="x" %>



<c:import var="xml" url="students.xml" />

<c:import var="xslt" url="transform.xsl" />
<x:transform xml="${xml}" xslt="${xslt}"/>




