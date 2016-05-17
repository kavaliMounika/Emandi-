<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@page import="com.myapp.javaclasses.UserDetailsBean"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>E-Market Online Market </title>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="jquery.poptrox-0.1.js"></script>
    </head>

</head>
<body>

<javascript formName="LoginDetailsActionForm"/>
<div id="header" class="container">
            <div id="logo">
                <h1><a href="#">E-Market  </a></h1>
                <p><a>Online market</a></p>
            </div>
            <div id="menu">
                <ul>
                    <li><a href="HomePage_1.jsp">Homepage</a></li>
                    <li><a href="UserDetails.jsp">Register</a></li>
                    <li><a href="Contact.jsp">Contact</a></li>
                    
                </ul>
            </div>
        </div>
        <!-- end #header -->
       
                           <div id="bg3">

                                
                            </div>

        <%@include file="Gallery1.jsp" %>
        <div id="page">
            <div id="bg1">
                <div id="bg2">
                    <div id="bg3">
                        <div id="content">

                  <h3> ${requestScope.msg} </h3><br>
                            <h3> ${requestScope.msg1}</h3>
                            <h2>LOGIN</h2>

 
<!--  <table border=2 width="83%" cellpadding="0" cellspacing="0"> -->
<!--   <tr valign="top"> -->
<!--    <td> -->
<!--    <center> -->
<!-- 	<h4> -->
<!--     	<font color="#FF0000"><i> -->
    	
<!-- 		</i></font> -->
<!--       </h4> -->
<!--     </center> -->
<!--    </td> -->
<!--   </tr>  -->
<!--   <tr valign="top" > -->
<!--    <td width = "84%" > -->
<!--     <P align=center><FONT color=#056796><STRONG><U>Registration Page</U></STRONG></FONT></P> -->
    <form action="LoginDetailsAction.do" method="post" onsubmit="return validateLoginDetailsActionForm(this);">
    <TABLE borderColor=#056796 cellSpacing=5 cellPadding=5 align=center border=0>
     <TBODY>
      <TR>
       <TD borderColor=#056796>
       <P align=right><FONT color=#056796>Email</FONT></P></TD>
       <TD borderColor=#056796><input type = "text" name = "userName" value = "" SIZE="16" />
       </TD>
      </TR>
<TR>
       <TD borderColor=#056796>
       <P align=right><FONT color=#056796>Password</FONT></P></TD>
       <TD borderColor=#056796><input type = "password" name = "password" value = "" SIZE="16" />
       </TD>
      </TR>
       <TR>
       <TD borderColor=#056796>
         <P align=center><input type = "submit"  value ="SUBMIT" /> <input type="reset" value="RESET"/></P>
        </TD></TR>
      </TBODY>
      </TABLE>
      </form>
      </table>
      </div>


                    </div>
                </div>
            </div>
        </div>
      <%@include file="Footer.jsp" %>
        <!-- end #footer -->
      
</body>
</html>