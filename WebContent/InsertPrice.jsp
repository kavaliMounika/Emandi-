<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>E-MArket Online Market </title>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="jquery.poptrox-0.1.js"></script>
    </head> <script type="text/javascript">

        function callMe1(distictId,cate)
        {

            var xmlhttp;

            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {

                    document.getElementById(distictId).innerHTML=xmlhttp.responseText;
                }
            }

            xmlhttp.open("POST","getDisticts.jsp?stateId="+cate.value,true);
            xmlhttp.send();

        }
    </script>

    <script type="text/javascript">

        function callMe2(regionId,cate)
        {
           
            var xmlhttp;

            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                   
                    document.getElementById(regionId).innerHTML=xmlhttp.responseText;
                }
            }

            xmlhttp.open("POST","getRegions.jsp?distictId="+cate.value,true);
            xmlhttp.send();

        }
    </script>


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
                            <%@include  file="setDatasource.jsp" %>
                            <sql:query var="State" dataSource="${dataSource}" sql="select StateId,StateName from State">
                            </sql:query>
                            <h2>Prices</h2>
                            <h1>${requestScope.msg2}</h1>
                            <h1>${requestScope.msg1}</h1>
                            <html:javascript formName="InsertPriceActionForm"/>
                            <html:form action="InsertPriceAction" method="post" onsubmit="return validateInsertPriceActionForm(this);">
                                <table>
                                    <thead>
                                        <tr>
                                            <td>State</td>
                                            <td>    <html:select property="stateId" onchange="callMe1('distictId',this)" >
                                                    <html:option value="">---Select State---</html:option>
                                                    <c:forEach  items="${State.rowsByIndex}" var="State">
                                                        <html:option value="${State[0]}">${State[1]}</html:option>
                                                    </c:forEach>

                                                </html:select>

                                            </td>
                                        </tr>

                                        <tr>
                                            <td>City</td>
                                            <td>
                                                <html:select property="distictId" styleId="distictId" onchange="callMe2('regionId',this)" >
                                                    <html:option value="">--Select City--</html:option>
                                                </html:select>
                                            </td>

                                        </tr>

                                        <tr>
                                            <td>Region</td>
                                            <td>
                                                <html:select property="regionId" styleId="regionId"  >
                                                    <html:option value="">--Select Region--</html:option>
                                                </html:select>
                                            </td>

                                        </tr>

                                        <tr>
                                            <td>Vegetable</td>
                                            <sql:query var="Vegetables" dataSource="${dataSource}" sql="select VegetableId, VegetableName from VegetableDetails"/>
                                            <td>
                                                <html:select property="vegetableId" >
                                                <html:option value="">--Select Vegetables--</html:option>
                                                <c:forEach var="vegetables" items="${Vegetables.rowsByIndex}">
                                                    <html:option value="${vegetables[0]}">${vegetables[1]}</html:option>
                                                </c:forEach>
                                                </html:select>
                                            </td>

                                        </tr>



                                        
                                    </thead>
                                    <tbody>

                                        

                                        <tr>
                                            <td>GovernmentPrice</td>
                                            <td><html:text property="governmentPrice" value=""/></td>
                                        </tr>
                                        <tr>
                                            <td>FarmerPrice</td>
                                            <td><html:text property="farmerPrice" value=""/></td>
                                        </tr>
                                        <tr>
                                            <td>WholeSellerPrice</td>
                                            <td><html:text property="wholeSellerPrice" value=""/></td>
                                        </tr>
                                        <tr>
                                            <td>RetailerPrice</td>
                                            <td><html:text property="retailerPrice" value=""/></td>
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