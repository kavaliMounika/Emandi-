<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>




<%@include  file="setDatasource.jsp" %>
<sql:query var="distict" dataSource="${dataSource}" sql="select DisticId,DistictName from Distict where StateId=?">
    <sql:param value="${param.stateId}"/>
</sql:query>


<option value="0">--Select City--</option>
<c:forEach var="distict" items="${distict.rowsByIndex}">
    <option value="${distict[0]}">${distict[1]}</option>
</c:forEach>
