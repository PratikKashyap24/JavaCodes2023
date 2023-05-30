<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Departments</title>
</head>
<body>
	<h2>Employee Management- Department List</h2>
	<hr />

	<c:choose>
		<c:when test="${department eq null }">
			<p>
				<strong>No data Found!</strong>
			</p>
		</c:when>
		<c:when test="${department.size() eq 0 }">
			<p>
				<strong>No Data Found!</strong>
			</p>
		</c:when>
		<c:otherwise>
			<table border="1" width="100%">
				<tr>
					<th>Department Number</th>
					<th>Department Name</th>
					<th>Employee ID</th>
				</tr>
				<c:forEach items="${department }" var="departments">
					<tr>
						<td>${departments.deptNo }</td>
						<td>${departments.deptName }</td>
						<td>${departments.empId }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<hr />
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
		</ul>
	</nav>
</body>
</html>