package newFolder;

<html><head>
        <%
        String mins = request.getParameter("mins");
        if (mins == null) {
            mins = "0";
        }

        String secs = request.getParameter("secs");
        if (secs == null) {
            secs = "10";
        }
        %>
        <script>
            <!--
            var mins = <%=mins%>; // write mins to javascript
            var secs = <%=secs%>; // write secs to javascript
            function timer()
            {
                // tic tac
                if( --secs == -1 )
                {
                    secs = 59;
                    --mins;
                }
                if( secs < 10 ) secs = "0" + secs;
                if( mins < 10 ) mins = "0" + parseInt( mins, 10 );
               
                document.forma.mins.value = mins;
                document.forma.secs.value = secs;
               
                if( secs == 0 && mins == 0 ) // time over
                {             
                    ww = window.open(window.location, "_self");
                    ww.close();
                }
                else // call timer() recursively every 1000 ms == 1 sec
                {
                    window.setTimeout("timer()", 1000 );
                }
            }
            //-->
    </script></head>
    <body>
        <form action="<%=request.getRequestURL()%>" name="forma">
            Time remaining: <input type="text" name="mins" size="1" style="border:0px solid black;text-align:right">:<input type="text" name="secs" size="1" style="border:0px solid black">
            <hr>
            <iframe width="100%" height="810px" src="http://localhost:8084/test/index.html"></iframe>
        </form>
        <hr>
        <form action="#" name="formb">
            <input type="submit" name="results" value="show results" style="display:none;">
        </form>
        <script>
            <!--
            timer(); // call timer() after page is loaded
            //-->
        </script>
</body></html>  