

<%
            HttpSession hs1 = request.getSession();
            int rol = (Integer) hs1.getAttribute("role");
            if (rol == 5) {
%>

<div id="sidebar">
    <h2> Links</h2>
    <ul>
        
        <li><a href="ViewPricesAction.do">ViewPrices</a></li>
        <li><a href="StateAction.do">PricesByRegion</a></li>
        <li><a href="ViewFeedBack.jsp">ViewFeedBack</a></li>
        

       



    </ul>
</div>
<%    } else if (rol == 6) {
%>

<div id="sidebar">
    <h2> Links</h2>
    <ul>
        <li><a href="InsertVegetableDetails.jsp">InsertVegetables</a></li>
        <li><a href="ViewVegetable1Action.do">InsertVegetableQuantity</a></li>
        <li><a href="InsertPrice.jsp">InsertPrices</a></li>
        <li><a href="InsertState.jsp">InsertStates</a></li>
        <li><a href="InsertDistict.jsp">InsertDistict</a></li>
        <li><a href="InsertRegion.jsp">InsertRegion</a></li>
        

    </ul>
</div>

<%    } else {

%>



<div id="sidebar">
    <h2>Links</h2>
    <ul>
        <li><a href="BookingRequestAction.do?comment=${sessionScope.id}">BookingRequests</a></li>
        <li><a href="BookingOrdersAction.do?comment=${sessionScope.id}">BookingOrders</a></li>
        <li><a href="QuantityRequest.jsp">IntroduceProduct</a></li>
        <li><a href="VegetableDetails.jsp">VegetableDetail</a></li>
        <li><a href="ViewPricesAction.do">ViewPrices</a></li>
        <li><a href="RoleSelect.jsp">Book Vegetables</a></li>
        <li><a href="StateAction.do">PricesByRegions</a></li>
        <li><a href="FeedBack.jsp">Feedback</a></li>




    </ul>
</div>

<%                    }


%>