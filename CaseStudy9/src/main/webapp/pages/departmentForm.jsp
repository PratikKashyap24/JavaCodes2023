<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Department Page</title>
</head>
<body>


	<form:form method="POST" modelAttribute="department">

		<div>
			<form:label path="deptNo">Department Id</form:label>
			<form:input type="number" path="deptNo" />
			<form:errors path="deptNo"></form:errors>
		</div>

		<div>
			<form:label path="deptName">Department Name</form:label>
			<form:input type="text" path="deptName" />
			<form:errors path="deptName"></form:errors>
		</div>



		<div>
			<form:label path="empId">Employee ID</form:label>
			<form:input type="number" path="empId" />
			<form:errors path="empId"></form:errors>
		</div>

		<div>
			<button>SAVE</button>
		</div>
	</form:form>
	<jsp:include page="/footer" />
</body>
</html>