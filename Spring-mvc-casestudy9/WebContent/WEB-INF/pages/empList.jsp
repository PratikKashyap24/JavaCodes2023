<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Registration</title>
</head>
<style type="text/css">

body {
	background-color:teal;
}
h1,table{
color: white;
}
h2{
}

</style>
<body>
	<div align="center">
		<h1>Employee Registration</h1>

		

		<table border="1" padding="5">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Company Id</th>
				<th>Gender</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${empList}" var="emp">
				<tr>
					
					
					<td>${emp.empId}</td>
					<td>${emp.empName}</td>
					<td>${emp.compId}</td>
					<td>${emp.gender}</td>
					
					<td><a href="edit?empId=${emp.empId}">EDIT</a> 
					<a href="delete?empId=${emp.empId}">DELETE</a></td>
				</tr>

			</c:forEach>
		</table>
		

	</div>
</body>