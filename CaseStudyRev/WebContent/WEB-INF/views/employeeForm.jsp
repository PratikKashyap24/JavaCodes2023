<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Employee Page</title>
</head>
<body>
	

	<form:form method="POST" modelAttribute="employee">

		<div>
			<form:label path="empId">Employee Id</form:label>
			<form:input type="number" path="empId" />
			<form:errors path="empId"></form:errors>
		</div>

		<div>
			<form:label path="empName">Employee Name</form:label>
			<form:input type="text" path="empName" />
			<form:errors path="empName"></form:errors>
		</div>

		<div>
			<form:label path="gender">Gender</form:label>
			<form:input type="text" path="gender" />
			<form:errors path="gender"></form:errors>
		</div>

		<div>
			<form:label path="compId">Company ID</form:label>
			<form:input type="number" path="compId" />
			<form:errors path="compId"></form:errors>
		</div>

		<div>
			<button>SAVE</button>
		</div>
	</form:form>
	<jsp:include page="/footer" />
</body>
</html>