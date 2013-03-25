package newFolder;



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html" %>
<%@ page session="true" %>
<%@ page language="java" %>

<%@ page import="java.util.*,java.io.*,java.sql.*"%>


<HTML><HEAD><TITLE>Management Information System</TITLE>

    <META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
    <STYLE type="text/css">
           BODY
           {
           MARGIN: 0px
           }
           </STYLE>

    <SCRIPT language=javascript>

        var hr = <%=request.getAttribute("HR")%>
        var sec = 00;
        var min =00;
        var count1;

        function countDown()
        {
            sec--;

            if (sec == -01)
            {
                sec = 18;
                min = min - 1;
            }
            else { min = min; }

            if (sec<=9)
            { sec = "0" + sec;
            }

            if(min==-01)
            {
                min=0;
                hr= hr++;
            }

            time = (hr<=9 ? "0" + hr : hr)+" : " + (min<=9 ? "0" + min : min)+ " : " + sec ;
            document.online.timeLeft.value = time;

            if (document.getElementById)
            {
                theTime.innerHTML = time;
            }

            SD=window.setTimeout("countDown();", 1000);

            if (hr=='00' && min == '00' && sec == '00')
            { sec = "00"; window.clearTimeout(SD);
                alert("The time is Expiered");


                var inputs=0;
                var cou=0;
                var aa;
                var examdate1 = document.online.examdate1.value;
                for(var x=0;x<10;x++)
                {
                    var name= new Array(10)
                    name[0]="TRAP";
                    name[1]="Dennisriche";
                    name[2]="ThomasJohn";
                    name[3]="MarkHoneywell";
                    name[4]="Active server pages";
                    name[5]="Shozo Kawasaki";
                    name[6]="Neither Process Nor Completes Its Work";
                    name[7]=" Western India Vegetable Products Limited";
                    name[8]="Java server pages";
                    name[9]="Object oriented";
                    //alert("array:"+name[x]);
                    inputs = document.getElementsByTagName('input')
                    for(var i=0; i < inputs.length; i++)
                    {
                        if(inputs[i].checked==true)
                        {
                            aa=inputs[i].value;
                            //alert("The selected value is"+aa);
                            if(aa==name[x])
                            {
                                cou++;
                            }
                        }
                    }
                }
                alert("count:"+cou);
                document.location.href="techexam.jsp?cou="+cou+"&examdate1="+examdate1+" ";
            }
        }
        window.onload = countDown;

    </script>

    <script text="javascript">

        function getValues()
        {
            //<%!int j = 1;%>
            var inputs=0;
            var cou=0;
            var aa;

            var examdate1 = document.online.examdate1.value;

            for(var x=0;x<10;x++)
            {
                var name= new Array(10)
                name[0]="TRAP";
                name[1]="Dennisriche";
                name[2]="ThomasJohn";
                name[3]="MarkHoneywell";
                name[4]="Active server pages";
                name[5]="Shozo Kawasaki";
                name[6]="Neither Process Nor Completes Its Work";
                name[7]=" Western India Vegetable Products Limited";
                name[8]="Java server pages";
                name[9]="Object oriented";
                //alert("array:"+name[x]);
                inputs = document.getElementsByTagName('input')
                for(var i=0; i < inputs.length; i++)
                {
                    if(inputs[i].checked==true)
                    {
                        aa=inputs[i].value;

                        if(aa==name[x])
                        {
                            cou++;
                        }
                    }
                }
            }
            alert("count:"+cou);
            document.location.href="techexam.jsp?cou="+cou+"&examdate1="+examdate1+" ";
        }

    </script>
    <script type="text/javascript" src="../JavaScript/datetimepicker.js"></script>

    <style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }
        -->
    </style>
    <link href="../css/form.css" rel="stylesheet" type="text/css">
    <link href="../css/style.css" rel="stylesheet" type="text/css">

   

    <FORM name="online">
        <TABLE cellSpacing=0 cellPadding=0 width=776 border=0>
          
            <TBODY>
                <TR>
                    <TD class=Form_Header bgColor=#999999>
                        <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                            <TBODY>
                                <TR>
                                    <TD class=popheader width=25>&nbsp;</TD>
                                    <TD class=popheader align=left width=222>Optitude Test </TD>
                                    <TD align=left width=242 height=25>&nbsp;</TD>
                                    <TD class=toplink vAlign=center align=left width=211>
                                        <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%"
                                               border=0>
                                            <TBODY>
                                                <TR>
                                                    <TD align=right width="28%"><LABEL></LABEL></TD>
                                                    <TD align=right width="28%"><LABEL></LABEL></TD>
                                                    <TD align=right width="25%"><LABEL></LABEL></TD>
                                                    <TD align=middle width="29%"><LABEL>
                </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
                <TR>
                    <TD>
                        <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                            <TBODY>
                                <TR>
                                <TD>&nbsp;</TD></TR>
                                <TR>
                                    <TD>
                                        <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                            <TBODY>


                                                Exam Timing::<SPAN class=timeClass id=theTime></SPAN>
                                                <SPAN class=labels id=theTime><input name="timeLeft" id=theTime size="10"></SPAN>
                                                <TR vAlign=top align=left>
                                                    <TD width="10%" height=35>&nbsp;</TD>
                                                    <TD class=labels borderColor=#dfeaff height=35>
                                                    <SPAN class=red_marker></SPAN></TD>
                                                    <TD borderColor=#dfeaff height=35>

                                                        <%
     
      
          

            
                                                        %>


                                                        
                                                     

                                </SPAN></SPAN></TD></TR></TBODY></TABLE></TD></TR>
                                <TR>
                                    <TD align=middle>
                                        <INPUT type=button value=submit onClick="getValues()">
        </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
    </FORM>
    </BODY>
</HTML>
