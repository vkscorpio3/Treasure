<%-- 
    Document   : sqlquery
    Created on : Aug 2, 2011, 12:37:04 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>SQL Query Tags</title>
</head>

<body>
<h2>Setup</h2>
<sql:update>
    drop table if exists measure;
    create table measure (
	id int,
	name varchar(20)
    );

    drop table if exists conversion;
    create table conversion (
	from_measure int,
	to_measure int,
	ratio decimal,
	last_updated timestamp default null
    );

    insert into measure (id, name) values (1, 'Inch');
    insert into measure (id, name) values (2, 'Feet');
    insert into measure (id, name) values (3, 'Yard');
    insert into measure (id, name) values (4, 'Centimeter');
    insert into measure (id, name) values (5, 'Meter');

    insert into conversion (from_measure, to_measure, ratio) values(1, 2, 0.0833);
    insert into conversion (from_measure, to_measure, ratio) values(1, 3, 0.0278);
    insert into conversion (from_measure, to_measure, ratio) values(1, 4, 2.540);
    insert into conversion (from_measure, to_measure, ratio) values(1, 5, 0.0254);
    insert into conversion (from_measure, to_measure, ratio) values(2, 1, 12);
    insert into conversion (from_measure, to_measure, ratio) values(2, 3, 0.3333);
    insert into conversion (from_measure, to_measure, ratio) values(2, 4, 30.48);
    insert into conversion (from_measure, to_measure, ratio) values(2, 5, 0.3048);
    insert into conversion (from_measure, to_measure, ratio) values(3, 1, 36);
    insert into conversion (from_measure, to_measure, ratio) values(3, 2, 3);
    insert into conversion (from_measure, to_measure, ratio) values(3, 4, 91.44);
    insert into conversion (from_measure, to_measure, ratio) values(3, 5, 0.9144);
    insert into conversion (from_measure, to_measure, ratio) values(4, 1, 0.3937);
    insert into conversion (from_measure, to_measure, ratio) values(4, 2, 0.0328);
    insert into conversion (from_measure, to_measure, ratio) values(4, 3, 0.0109);
    insert into conversion (from_measure, to_measure, ratio) values(4, 5, 0.01);
    insert into conversion (from_measure, to_measure, ratio) values(5, 1, 39.37);
    insert into conversion (from_measure, to_measure, ratio) values(5, 2, 3.2801);
    insert into conversion (from_measure, to_measure, ratio) values(5, 3, 1.0936);
    insert into conversion (from_measure, to_measure, ratio) values(5, 4, 100);
</sql:update>
done.

<h2>Query</h2>
<sql:query var="conversionRatio">
    SELECT c.ratio, m2.name
    FROM measure m1, conversion c, measure m2
    WHERE m1.id = c.from_measure
    AND c.to_measure = m2.id
    AND m1.name = ?
    <sql:param value="Meter"/>
</sql:query>

1 Meter is:<br>
<ul>
<c:forEach var="row" items="${conversionRatio.rows}">
    <li> ${row.ratio} ${row.name}.</li>
</c:forEach>
</ul>
</body>
</html>

