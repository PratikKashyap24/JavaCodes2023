<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add Company</title>
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
		<h1>Company Form</h1>
		<form:form action="saveComp" method="post" modelAttribute="company">
			<table>
				<tr>
					<td>Company Id</td>
					<td><form:input path="compId" /></td>
				</tr>
				<tr>
					<td>Company Name</td>
					<td><form:input path="compName" /></td>
				</tr>
				
				
				
					<td colspan="2"><button>Save</button></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>