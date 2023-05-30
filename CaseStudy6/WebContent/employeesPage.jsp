<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Employees</title>
</head>
<body>
	<h2>Employee Data- </h2>
	<hr />

	<c:choose>
		<c:when test="${employees eq null }">
			<p>
				<strong>No data Found!</strong>
			</p>
		</c:when>
		<c:when test="${employees.size() eq 0 }">
			<p>
				<strong>No Data Found!</strong>
			</p>
		</c:when>
		<c:otherwise>
			<table border="1" width="100%">
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Gender</th>
					<th>Company Id</th>
				</tr>
				<c:forEach items="${employees }" var="employee">
					<tr>
						<td>${employee.empId }</td>
						<td>${employee.empName }</td>
						<td>${employee.gender }</td>
						<td>${employee.compId }</td>
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