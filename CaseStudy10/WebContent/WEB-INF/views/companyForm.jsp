<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Department Page</title>
</head>
<body>


	<form:form method="POST" modelAttribute="company">

		<div>
			<form:label path="compId">Company Id</form:label>
			<form:input type="number" path="compId" />
			<form:errors path="compId"></form:errors>
		</div>

		<div>
			<form:label path="compName">Company Name</form:label>
			<form:input type="text" path="compName" />
			<form:errors path="compName"></form:errors>
		</div>



		<div>
			<button>SAVE</button>
		</div>
	</form:form>
	<jsp:include page="/footer" />
</body>
</html>