<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Department - Home</title>
<style type="text/css">

body {
	background-color:teal;
}
td,th,h1{
	color: white;
	text-align: center;
}
h1{
text-decoration: underline;
}

</style>
</head>
<body>
<h1 >
Department List
</h1>

	

	<c:choose>
		<c:when test="${department ne null and department.size()>0 }">
			<table border="1" width="100%" style="border-color: white">
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