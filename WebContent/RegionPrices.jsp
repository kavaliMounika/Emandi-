<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <title>E-Market Online Market </title>
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
                            <h2>Prices</h2>

                            <h3> ${requestScope.msg2}</h3>
                            <table>
                                <c:if test="${!empty requestScope.rprices}">
                                <tr>
                                     <td align="center"><h3 style="background-color: darkseagreen">Vegetable</h3></td>
                                     <td align="center"><h3 style="background-color: darkseagreen">GovtPrice</h3></td>
                                     <td align="center"><h3 style="background-color: darkseagreen">FrmrPrice</h3></td>
                                     <td align="center"><h3 style="background-color: darkseagreen">W-price</h3></td>
                                    <td align="center"><h3 style="background-color: darkseagreen">R-Price</h3></td>
                                </tr>
                                </c:if>
                                <c:forEach items="${requestScope.rprices}" var="rp">

                                    <tr> 
                                        <td><h3> <c:out value="${rp.vegetableName}"/></h3> </td>
                                        <td><h3> <c:out value="${rp.governmentPrice}"/></h3> </td>
                                        <td><h3> <c:out value="${rp.farmerPrice}"/></h3> </td>
                                        <td><h3> <c:out value="${rp.wholeSellerPrice}"/></h3> </td>
                                        <td ><h3> <c:out value="${rp.retailerPrice}"/></h3> </td>

                                    </tr>

                                </c:forEach>
                            </table>
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