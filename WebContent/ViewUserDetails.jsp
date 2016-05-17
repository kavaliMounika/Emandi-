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
                            <h2>Users Report</h2>

                            <html:javascript formName="ViewUserDetailsActionForm"/>
                            <html:form action="UserDetailsViewAction" method="post" onsubmit="return validateViewUserDetailsActionForm(this);" >

                                <table>
                                    <tr>
                                        <td><h3>Type:</h3></td>
                                        <td style="background-color: darkseagreen">
                                            <%@include  file="setDatasource.jsp" %>
                                            <sql:query var="Role" dataSource="${dataSource}" sql="select RoleID,RoleName from Role where RoleId !=5 and RoleId !=6"/>

                                            <html:select property="roleId" value="" >
                                                <html:option value="">--Select Type--</html:option>
                                                <c:forEach var="role" items="${Role.rowsByIndex}" >
                                                    <html:option value="${role[0]}">${role[1]}</html:option>
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
                            <h3> ${requestScope.msg2} </h3>
                            <table>
                                <c:if test="${!empty requestScope.userDetails}">
                                    <tr>
                                        <td style="background-color: darkseagreen"><h3>Name</h3></td>
                                        <td></td><td></td><td></td>
                                        <td style="background-color: darkseagreen"><h3>Address</h3></td>
                                        <td></td><td></td><td></td>

                                        <td style="background-color: darkseagreen"><h3>PhoneNumber</h3></td>
                                        <td></td><td></td><td></td>
                                       
                                    </tr>
                                </c:if>

                                <c:forEach items="${requestScope.userDetails}" var="ud">
                                    <tr><td><h4> <c:out value="${ud.name}"/></h4></td>
                                        <td></td><td></td><td></td>
                                        <td><h4><c:out value="${ud.address}"/> </h4></td>
                                        <td> </td><td></td><td></td>
                                        <td><h4><c:out value="${ud.phoneNumber}"/> </h4></td>
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