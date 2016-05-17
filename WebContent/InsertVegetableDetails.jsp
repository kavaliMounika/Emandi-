<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

Name       : Photoshoot
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20110926

-->
<html>
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>E-MANDI Online Market </title>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="jquery.poptrox-0.1.js"></script>
    </head>
    <body>
        <div id="header" class="container">
            <div id="logo">
                <h1><a href="#">E-MANDI </a></h1>
                <p><a>Online market</a></p>
            </div>
            <%@include file="Header.jsp"%>
        </div>
        <!-- end #header -->

        <div id="page">
            <div id="bg1">
                <div id="bg2">
                    <div id="bg3">


                    <div id="content">
                       <h2>VegetableDetails</h2>
            <h1>${requestScope.msg2}</h1>
            <h1>${requestScope.msg1}</h1>
            <h1>${requestScope.msg3}</h1>

            <javascript formName="InsertVegetableDetailsActionForm"/>
            <form action="InsertVegetableDetailsAction.do" method="post" onsubmit="return validateInsertVegetableDetailsActionForm(this);">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2">VegetableDetails</th>

                        </tr>
                    </thead>
                    <tbody>


                        <tr>
                            <td>VegetableName</td>
                            <td><input type = "text" name="vegetableName" value=""/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="SUBMIT"/> </td>
                            <td><input type="reset" value="RESET"/></td>
                            <td><a href="ComputerProfessional.jsp"> <input type="button" value="Back" name="Back" /></a></td>
                        </tr>
                    </tbody>
                </table>



            </form>

        </div>
                        <%@include file="SideBar.jsp"%>

                         </div>
                </div>
            </div>
        </div>


        <%@include file="Gallery1.jsp" %>

      <%@include file="Footer.jsp" %>
        <!-- end #footer -->
    </body>
</html>