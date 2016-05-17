<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<%@include file="setDatasource.jsp" %>
<sql:query var="aq" dataSource="${dataSource}" sql="select AvailableQuantity from VegetableQuantity where UserId=? and VegetableId=?">
    <sql:param value="${param.bookingTo}"/>
    <sql:param value="${param.vegetableId}"/>
</sql:query>


<c:forEach var="region" items="${aq.rowsByIndex}">
    <c:out value="${region[0]}"></c:out>
  
</c:forEach>
