<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<%@include file="setDatasource.jsp" %>
<sql:query var="Vegetables" dataSource="${dataSource}" sql="select PriceDetails.VegetableId, VegetableDetails.VegetableName from PriceDetails INNER JOIN VegetableDetails ON PriceDetails.VegetableId=VegetableDetails.VegetableId where RegionId=?">
    <sql:param value="${param.regionId}"/>
</sql:query>

<option value="0">--Select Vegetables--</option>
<c:forEach var="vegetables" items="${Vegetables.rowsByIndex}">
    <option value="${vegetables[0]}">${vegetables[1]}</option>
</c:forEach>
