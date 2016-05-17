<%
            HttpSession hs = request.getSession();
            int rol1 = (Integer) hs.getAttribute("role");
            if (rol1 == 5) {
%>

<div id="menu">
                <ul>
                    <li><a href="Admin.jsp">Homepage</a></li>
                   
                    </li>
                    <li><a href="Contact.jsp" >Contact</a></li>
                    <li><a href="Logout.jsp">Logout</a></li>
                </ul>
            </div>

<%    } else if (rol1 == 6) {
%>

 <div id="menu">
                <ul>
                    <li><a href="ComputerProfessional.jsp">Homepage</a></li>
                    <li><a href="Contact.jsp" >Contact</a></li>
                    <li><a href="Logout.jsp">Logout</a></li>
                </ul>
            </div>

<%    } else {

%>



 <div id="menu">
                <ul>
                     <li><a href="DisplayPage.jsp">Homepage</a></li>
                    <li><a href="Contact.jsp" >Contact</a></li>
                    <li><a href="Logout.jsp">Logout</a></li>
                </ul>
            </div>

<%                    }


%>