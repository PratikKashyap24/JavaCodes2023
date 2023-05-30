<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Employee - Home</title>
</head>
<body>

	

	<c:choose>
		<c:when test="${employee ne null and employee.size()>0 }">
			<table border="1" width="100%">
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Gender</th>
					<th>Company Id</th>
					
				</tr>
				<c:forEach items="${employee }" var="employee">
					<tr>
						<td>${employee.empId }</td>
						<td>${employee.empName }</td>
						<td>${employee.gender }</td>
						<td>${employee.compId }</td>
						
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>
				<strong>No Employee Found!</strong>
		</c:otherwise>
	</c:choose>

	<jsp:include page="/footer" />
</body>
</html>