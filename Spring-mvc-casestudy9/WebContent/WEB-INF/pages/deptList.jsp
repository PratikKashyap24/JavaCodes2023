<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Department List</title>
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
		<h1>Department List</h1>

		<!-- <h3>
			<a href="new">New Company</a>
		</h3>
 -->
		
		
		<table border="1" padding="5">
			<tr>
				<th>Department Number</th>
				<th>Department Name</th>
				<th>Employee Id</th>
				
				
			</tr>

			<c:forEach items="${deptList}" var="dept">
				<tr>
					
					
					<td>${dept.deptNo}</td>
					<td>${dept.deptName}</td>
					
					<td>${dept.empId}</td>
					
					 
				</tr>

			</c:forEach>
		</table>
		
		

	</div>
</body>