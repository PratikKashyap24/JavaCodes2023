<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add Department</title>
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
		<h1>Department Form</h1>
		<form:form action="saveDept" method="post" modelAttribute="department">
			<table>
				<tr>
					<td>Department Number</td>
					<td><form:input path="deptNo" /></td>
				</tr>
				<tr>
					<td>Department Name</td>
					<td><form:input path="deptName" /></td>
				</tr>
				<tr>
					<td>Employee Id</td>
					<td><form:input path="empId" /></td>
				</tr>
				
				
				
					<td colspan="2"><button>Save</button></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>