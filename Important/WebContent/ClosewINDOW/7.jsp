package newFolder;

<%-- 
    Document   : 7
    Created on : Jul 27, 2011, 3:10:45 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

                                     /* Z-index of #hide must lower than #container .window */
                                     #hide {
                                         position:absolute;
                                         z-index:9000;
                                         background-color:#000;
                                         display:none;
                                     }

                                     container .window {
                                         position:absolute;
                                         width:440px;
                                         height:200px;
                                         display:none;
                                         z-index:9999;
                                         padding:20px;
                                     }


                                     /* Customize your modal window here, you can add background image too */
                                     #container #openbox {
                                         width:375px;
                                         height:203px;
                                     }
        </style>
        <script type="text/javascript">
            $(document).ready(function() {

                //select all the a tag with name equal to modalwindow
                $('a[name=modalwindow]').click(function(e) {
                    //Cancel the link behavior
                    e.preventDefault();
                    //Get the A tag
                    var id = $(this).attr('href');

                    //Get the screen height and width
                    var hideHeight = $(document).height();
                    var hideWidth = $(window).width();

                    //Set heigth and width to hide to fill up the whole screen
                    $('#hide').css({'width':hideWidth,'height':hideHeight});

                    //transition effect
                    $('#hide').fadeIn(1000);
                    $('#hide').fadeTo("slow",0.8);

                    //Get the window height and width
                    var winH = $(window).height();
                    var winW = $(window).width();

                    //Set the popup window to center
                    $(id).css('top',  winH/2-$(id).height()/2);
                    $(id).css('left', winW/2-$(id).width()/2);

                    //transition effect
                    $(id).fadeIn(2000);

                });

                //if close button is clicked
                $('.window .close').click(function (e) {
                    //Cancel the link behavior
                    e.preventDefault();
                    $('#hide, .window').hide();
                });

                //if hide is clicked
                $('#hide').click(function () {
                    $(this).hide();
                    $('.window').hide();
                });

            });


        </script>
    </head>
    <body>
        <!-- #dialog is the id of a DIV defined in the code below -->
        <a name="modalwindow" href="#open">Open</a>

        <div>

            <!--You easily customize your window here -->

            <div class="window">
                <strong>Testing of Modal Window</strong> |

                <!-- close button is defined as close window -->
                <a class="close" href="#">Close window</a>

            </div>

            <!-- Do not remove div#hide, because you shall need it to fill the whole screen -->

        </div>
    </body>
</html>
