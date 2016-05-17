<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<%@include file="setDatasource.jsp" %>
<sql:query var="Region" dataSource="${dataSource}" sql="select RegionId,RegionName from Region where DistictId=?">
    <sql:param value="${param.distictId}"/>
</sql:query>

<option value="0">--Select Region--</option>
<c:forEach var="region" items="${Region.rowsByIndex}">
    <option value="${region[0]}">${region[1]}</option>
</c:forEach>
