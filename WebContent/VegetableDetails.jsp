<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <%@include file="setDatasource.jsp"%>
                            <sql:query var="vi" dataSource="${dataSource}" sql="select VegetableId, VegetableName from VegetableDetails"/>
                            <br/>
                            <br/><br/>
                            <h3>Select Vegetable to view Details</h3>
                            <br/><br/>
                            <br/>
                            <br/>
                            <html:form action="Vegetables" method="POST">
                                <table>
                                    <tr>
                                        <td></td></tr>
                                    <tr>
                                        <td style="background-color: darkseagreen"><html:select property="vegetableId" >
                                                <html:option value="">--SelectVegetable--</html:option>
                                                <c:forEach var="veg" items="${vi.rowsByIndex}" >
                                                    <html:option value="${veg[0]}">${veg[1]}</html:option>
                                                </c:forEach>
                                            </html:select></td>
                                    </tr>
                                    </table><table>
                                    <tr><td style="background-color: darkseagreen"><html:submit value="SUBMIT" /></td></tr>
                                </table>
                            </html:form>
                            <table>
                                <c:if test="${!empty requestScope.details}" >
                                <tr>
                                     <td align="center"><h3 style="background-color: darkseagreen"> Name</h3></td>
                                    <td>   </td>
                                 <td align="center"><h3 style="background-color: darkseagreen"> Type</h3></td>
                                    <td>   </td>
                             <td align="center"><h3 style="background-color: darkseagreen"> Vegetable </h3></td>
                                    <td> </td>
                                 <td align="center"><h3 style="background-color: darkseagreen"> VegetableQuantity</h3></td>
                                  <td> </td>
                                 <td align="center"><h3 style="background-color: darkseagreen"> AvailableQuantity</h3></td>
                                </tr>
                                </c:if>
                                <c:forEach items="${requestScope.details}" var="d">
                                    <tr>
                                        <td align="center"><h4><c:out value="${d.name}"/></h4> </td>
                                        <td> </td>
                                        <td align="center"><h4><c:out value="${d.rName}"/></h4> </td>
                                        <td> </td>
                                        <td align="center"><h4><c:out value="${d.vegetableName}"/></h4></td>
                                        <td> </td>
                                        <td align="center"><h4><c:out value="${d.vegetableQuantity}"/></h4></td>
                                        <td> </td>
                                        <td align="center"><h4><c:out value="${d.availableQuantity}"/></h4></td>


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