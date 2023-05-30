<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Department Page</title>
<style type="text/css">
body {
	background-color: teal;
}

td {
	color: white;
}
</style>
</head>
<body>

	<div align="center" style="margin-top: 80px;">
		<form:form method="POST" modelAttribute="department">

			<table>

				<tr>
					<td><form:label path="deptNo">Department Id</form:label></td>
					<td><form:input type="number" path="deptNo" /></td>
					<td><form:errors path="deptNo"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="deptName">Department Name</form:label></td>
					<td><form:input type="text" path="deptName" /></td>
					<td><form:errors path="deptName"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="empId">Employee ID</form:label></td>
					<td><form:input type="number" path="empId" /></td>
					<td><form:errors path="empId"></form:errors></td>
				</tr>
				<tr colspan="3">
					<td><button>SAVE</button></td>
				</tr>



			</table>
		</form:form>
	</div>
	<jsp:include page="/footer" />
</body>
</html>