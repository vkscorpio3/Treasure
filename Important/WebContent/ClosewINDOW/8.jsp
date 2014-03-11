package newFolder;

<%-- 
    Document   : 8
    Created on : Jul 27, 2011, 3:30:59 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Simple JQuery Modal Window from Queness</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.js"></script>

        <script type="text/javascript">
            
            $(document).ready(function() {

                var id = '#dialog';

                //Get the screen height and width
                var maskHeight = $(document).height();
                var maskWidth = $(window).width();

                //Set heigth and width to mask to fill up the whole screen
                $('#mask').css({'width':maskWidth,'height':maskHeight});

                //transition effect
                $('#mask').fadeIn(1000);
                $('#mask').fadeTo("slow",0.8);

                //Get the window height and width
                var winH = $(window).height();
                var winW = $(window).width();

                //Set the popup window to center
                $(id).css('top',  winH/2-$(id).height()/2);
                $(id).css('left', winW/2-$(id).width()/2);

                //transition effect
                $(id).fadeIn(2000);

                //if close button is clicked
                $('.window .close').click(function (e) {
                    //Cancel the link behavior
                    e.preventDefault();


                    $('#mask').hide();
                    $('.window').hide();
                });

                //if mask is clicked
                $('#mask').click(function () {
                    $(this).hide();
                    $('.window').hide();
                });

            });

            $("#iagree").click(function(){
                window.opener.$("#accept-terms").attr("checked","checked");
                window.close(); });

        </script>

        <style type="text/css">
            body {
                font-family:verdana;
                font-size:15px;
                margin:0 ;
            }

            a {color:#333; text-decoration:none}
            a:hover {color:#ccc; text-decoration:none}

            #mask {

                left:0;
                top:0;
                z-index:9000;
                background-color:#000;

                margin:0;
            }
            #boxes .window {
                position:absolute;

                left:0;
                top:0;
                display:none;
                z-index:9999;
                margin:0;
            }
            #boxes #dialog {

                width:1280px;
                height:817px;
                margin:0;
                left:0;
                top:0;
                background-color:#ffffff;
            }
        </style>
    </head><body>



        <div id="boxes">
            <div id="dialog" class="window">
                Simple Modal Window |
                <a href="#" class="close">Close it</a>
                <iframe width="100%" height="810px" src="http://localhost:8084/test/index.html"></iframe>
            </div>

            <div style="width: 1478px; height: 602px; display: none; opacity: 0.8;" id="mask">

            </div>

            <a href="#" id="iagree">a</a>

        </div>
    </body>
</html>
