<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Department - Home</title>
</head>
<body>

	

	<c:choose>
		<c:when test="${department ne null and department.size()>0 }">
			<table border="1" width="100%">
				<tr>
					<th>Department Id</th>
					<th>Department Name</th>
					<th>Employee Id</th>
					
					
				</tr>
				<c:forEach items="${department }" var="department">
					<tr>
						<td>${department.deptNo }</td>
						<td>${department.deptName }</td>
						<td>${department.empId }</td>
						
						
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>
				<strong>No Department Found!</strong>
		</c:otherwise>
	</c:choose>

	<jsp:include page="/footer" />
</body>
</html>