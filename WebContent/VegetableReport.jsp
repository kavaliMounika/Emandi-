<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

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
            <%@include file="Header.jsp" %>
        </div>
        <!-- end #header -->

        <div id="page">
            <div id="bg1">
                <div id="bg2">
                    <div id="bg3">


                        <div id="content">
                            
                            <br/>
                            <br/>
                            <br/>
                            <br/>
                            <br/>
<h2>VegetableReport</h2>

                            <html:javascript formName="VegetableReportActionForm"/>
                            <html:form action="VegetableReportAction" method="post" onsubmit="return validateVegetableReportActionForm(this);" >

                                <table>
                                    <tr>
                                        <td><h3>Vegetable:</h3></td>
                                        <td style="background-color: darkseagreen">
                                            <%@include  file="setDatasource.jsp" %>
                                            <sql:query var="VegetableId" dataSource="${dataSource}" sql="select VegetableId,VegetableName from VegetableDetails"/>

                                            <html:select property="vegetableId" value="" >
                                                <html:option value="">--Select Type--</html:option>
                                                <c:forEach var="vegetableId" items="${VegetableId.rowsByIndex}" >
                                                    <html:option value="${vegetableId[0]}">${vegetableId[1]}</html:option>
                                                </c:forEach>
                                            </html:select>

                                        </td>
                                    </tr>
                                </table><table>
                                    <tr>
                                        <td style="background-color: darkseagreen"><html:submit value="SUBMIT"/>  </td>
                                    </tr>
                                </table>
                            </html:form>
                            <br/>
                            <br/>
                            <h3> ${requestScope.no} </h3>
                            <table>
                                <c:if test="${!empty requestScope.vegetableDetails}">
                                    <tr>
                                        <td style="background-color: darkseagreen"><h3>VegetableName</h3></td>
                                        <td></td><td></td><td></td>
                                        <td style="background-color: darkseagreen"><h3>Total</h3></td>
                                        <td></td><td></td><td></td>

                                       

                                    </tr>
                                </c:if>

                                <c:forEach items="${requestScope.vegetableDetails}" var="vd">
                                    <tr><td><h4> <c:out value="${vd.vegetableName}"/></h4></td>
                                        <td></td><td></td><td></td>
                                        <td><h4><c:out value="${vd.totalQuantity}"/>kg </h4></td>
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