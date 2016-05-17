<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

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
                <h1><a href="#">E-Market </a></h1>
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

                            <html:form action="ViewAvailableQuantityAction" method="POST">

                                <table>
                                    <tr>

                                        <td><html:hidden property="userId" value="${param.comment}"/></td>

                                    </tr>

                                    <tr>
                                        <td>Vegetable</td>
                                        <td><html:select property="vegetableId">
                                                <html:option value="">--Select Vegetable--</html:option>
                                                <c:forEach items="${requestScope.veg}" var="v">
                                                    <html:option value="${v.vegetableId}">${v.vegetableName}</html:option>

                                                </c:forEach>

                                            </html:select></td>
                                    </tr>

                                    <tr>
                                         <td>AvailableQuantity</td>
                                        <td>
                                            <c:forEach items="${requestScope.qty}" var="q">
                                                <c:out value="${q.availableQuantity}"/>
                                            </c:forEach>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td><html:submit value="SUBMIT"/></td>
                                         <td><a href="ViewVegetablesAction.do?comment=${r.userId}">Book</a> </td>
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