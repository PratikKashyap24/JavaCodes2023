<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Companies</title>
</head>
<body>
	<h2>Employee Management- Company List</h2>
	<hr />

	<c:choose>
		<c:when test="${company eq null }">
			<p>
				<strong>No data Found!</strong>
			</p>
		</c:when>
		<c:when test="${company.size() eq 0 }">
			<p>
				<strong>No Data Found!</strong>
			</p>
		</c:when>
		<c:otherwise>
			<table border="1" width="100%">
				<tr>
					<th>Company Id</th>
					<th>Company Name</th>

				</tr>
				<c:forEach items="${company }" var="compani">
					<tr>
						<td>${compani.compId }</td>
						<td>${compani.compName }</td>

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