<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Name       : Photoshoot
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20110926

-->
<html:html>
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
                            <h2>BOOKING</h2>
                            <h1>${requestScope.msg3}</h1>
                            <h1>${requestScope.emp}</h1>

                            <h3 style=" font-weight: bolder"> For an easy flow please check the <a href="VegetableDetails.jsp">VegetableDetails</a></h3>
                                <br/>
                                <br/>
                                <br/>
                            <html:form action="FarmerAction" method="POST">
                                 <h3>Booking From:</h3>
                                <h2>${requestScope.FAIL}</h2>
                                <table>
                                   
                                    <tr>
                                        <td><html:hidden property="userId" value="${sessionScope.id}"/> </td>
                                    </tr>
                                    <tr>
                                        <td><h3>Type:</h3></td>
                                        
                                        <td style="background-color: darkseagreen"><html:select property="roleId">
                                                <html:option value="-1">--selectType--</html:option>
                                                <html:option value="1">Farmer</html:option>
                                                <html:option value="2">WholeSeller</html:option>
                                                <html:option value="3">Retailer</html:option>
                                            </html:select></td>
                                    </tr>
                                    <tr></tr><tr></tr><tr></tr>
                                    <tr>
                                        <td><html:submit value="SUBMIT"/> </td>
                                    </tr>
                                </table>
                            </html:form>
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
</html:html>