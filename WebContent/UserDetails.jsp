<%-- 
    Document   : UserDetails
    Created on : 22 Oct, 2012, 2:40:33 PM
    Author     : trainee
--%>

<%@page import="com.myapp.javaclasses.UserDetailsBean"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



<!--


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
       <html:javascript formName="UserDetailsActionForm"/>
        <div id="header" class="container">
            <div id="logo">
                <h1><a href="#">E-Market </a></h1>
                <p><a>Online market</a></p>
            </div>
            <div id="menu">
                <ul>
                    <li><a href="HomePage_1.jsp">Homepage</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                    <li><a href="Contact.jsp">Contact</a></li>
                    
                </ul>
            </div>
        </div>
        <!-- end #header -->

        
        <div id="poptrox1">
        
                               
                                     </div>

                                     <%@include file="Gallery1.jsp" %>
    



        <div id="page">
            <div id="bg1">
                <div id="bg2">
                    <div id="bg3">
                        <div id="content">
                            <h3> ${requestScope.msg1} </h3> <br>
                                  <h2>REGISTER</h2>
                                <html:form action="UserDetailsAction" method="post"  onsubmit="validateUserDetailsActionForm(this)">
                                <table>


                                    <tr>
                                        <td>Post</td>
                                        <td><html:select property="roleId">
                                                <html:option value="">--SelectUser--</html:option>
                                                <html:option value="1">Farmer</html:option>
                                                <html:option value="2">Whole Seller</html:option>
                                                <html:option value="3">Retailer</html:option>
                                                <html:option value="4">Civilian</html:option>


                                            </html:select></td>
                                    </tr>

                                    <tr>
                                        <td>Name</td>
                                        <td><html:text property="name" value=""/> </td>
                                    </tr>

                                    <tr>
                                        <td>Email</td>
                                        <td><html:text property="userName" value="" /></td>
                                    </tr>


                                    <tr>
                                        <td>Password</td>
                                        <td><html:password property="password" value=""/></td>
                                    </tr>


                                    <tr>
                                        <td>Address</td>
                                        <td><html:textarea property="address" value=""/></td>
                                    </tr>


                                    <tr>
                                        <td>PhoneNumber</td>
                                        <td><html:text property="phoneNumber" value=""/></td>
                                    </tr>
                                    <tr>
                                        <td><html:submit value="SUBMIT"/> <html:reset value="RESET"/></td>

                                    </tr>

                                </table>
                            </html:form>
                                
                               
                        </div>
                       

                    </div>
                </div>
            </div>
        </div>
      <%@include file="Footer.jsp" %>
        <!-- end #footer -->
    </body>
</html:html>








