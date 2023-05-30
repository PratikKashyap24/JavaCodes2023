<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Company List</title>
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
		<h1>Company List</h1>

		
		
		<table border="1" padding="5">
			<tr>
				<th>Company Id</th>
				<th>Company Name</th>
				
				
			</tr>

			<c:forEach items="${compList}" var="comp">
				<tr>
					
					
					<td>${comp.compId}</td>
					<td>${comp.compName}</td>
					
					 
				</tr>

			</c:forEach>
		</table>
		
		

	</div>
</body>