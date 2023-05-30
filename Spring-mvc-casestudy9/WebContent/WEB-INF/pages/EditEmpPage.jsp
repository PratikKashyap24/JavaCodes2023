<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>New Employee</title>
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
		<h1>Employee Form Edit</h1>
		<form:form method="post" modelAttribute="employee">
			<table>
				<tr>
					<td>Employee Name</td>
					<td><form:input path="empName" /></td>
				</tr>
				<tr>
					<td>Company Id</td>
					<td><form:input path="compId" /></td>
				</tr>
				
				
				<tr>
					<td>Gender</td>
					<td>Male:<form:radiobutton path="gender" value="Male" />
						Female:<form:radiobutton path="gender" value="Female" />
					</td>
				</tr>

				<tr>
					<td colspan="2"><button>Save</button></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>