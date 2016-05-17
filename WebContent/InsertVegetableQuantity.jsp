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
                            <h2>Requested Quantity</h2>
                            <h1>${requestScope.msg2}</h1>
                            <h1>${requestScope.msg1}</h1>
                            <h1>${requestScope.emp}</h1>
                            <%@include file="setDatasource.jsp" %>
                            <sql:query var="qr" dataSource="${dataSource}" sql="select UserDetails1.Name,VegetableDetails.VegetableName,QuantityRequest.Quantity,QuantityRequest.UserId,QuantityRequest.Status,QuantityRequest.VegetableId from QuantityRequest INNER JOIN VegetableDetails ON VegetableDetails.VegetableId=QuantityRequest.VegetableId INNER JOIN UserDetails1 ON UserDetails1.UserId= QuantityRequest.UserId where Status='Pending'"/>
                            <table>
                                <c:if test="${!empty qr.rowsByIndex}">
                                    <tr>
                                        <td style="background-color: darkseagreen"><h3>Name</h3></td>
                                        <td></td>
                                        <td style="background-color: darkseagreen"><h3>Vegetable</h3></td>
                                        <td style="background-color: darkseagreen"><h3>Quantity</h3></td>
                                        <td style="background-color: darkseagreen"><h3>Status</h3></td>
                                    </tr>

                                </c:if>

                                

                                    <c:forEach items="${qr.rowsByIndex}" var="r">
                                        <tr>
                                          <td>  <h4><c:out value="${r[0]}"/></h4></td>
                                            <td></td>
                                           <td><h4> <c:out value="${r[1]}"/></h4></td>
                                          <td> <h4><c:out value="${r[2]}"/></h4></td>
                                          <td> <h4><c:out value="${r[4]}"/></h4></td>
                                          <td><h4><a href="DeleteQuantityRequestAction.do?comment=${r[3]}&&comment1=${r[5]}">Accept</a></h4></td>
                                         </tr>
                                    </c:forEach>


                               

                            </table>
                            <br/>
                            <br/>
                            <br/>


                                 <h2>Quantity</h2>
                            <html:javascript formName="InsertVegetableQuantityActionForm"/>
                            <html:form action="InsertVegetableQuantityAction.do" method="post" onsubmit="return validateInsertVegetableQuantityActionForm(this);">
                                <table>
                                    <thead>
                                        <tr>
                                            <th colspan="2">VegetableQuantity</th>

                                        </tr>
                                    </thead>
                                    <tbody>

                                       
                                        <sql:query var="u" dataSource="${dataSource}" sql="select UserId,name from UserDetails1 where RoleId !=5 and RoleId !=6 and RoleId !=4;"/>
                                        <tr>
                                            <td>UserId</td>
                                            <td><html:select property="userId" >
                                                    <html:option value="">--selectUser--</html:option>
                                            <c:forEach items="${u.rowsByIndex}" var="ui">
                                                <html:option value="${ui[0]}">${ui[1]}</html:option>
                                            </c:forEach>
                                            </html:select></td>
                                        </tr>
                                        <tr>
                                            <td>Vegetable</td>
                                            <td><html:select property="vegetableId">
                                                    <html:option value="">--selectVegetable--</html:option>
                                                    <c:forEach items="${sessionScope.veg}" var="v">
                                                        <html:option value="${v.vegetableId}">${v.vegetableName}</html:option>
                                                    </c:forEach>
                                                </html:select></td>
                                        </tr>
                                        <tr>
                                            <td>VegetableQuantity</td>
                                            <td><html:text property="vegetableQuantity" value=""/></td>
                                        </tr>

                                        <tr>
                                            <td><html:submit value="SUBMIT"/> </td>
                                            <td><html:reset value="RESET"/></td>
                                            <td><a href="ComputerProfessional.jsp"><input type="button" value="Back" name="Back" /></a></td>
                                        </tr>
                                    </tbody>
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