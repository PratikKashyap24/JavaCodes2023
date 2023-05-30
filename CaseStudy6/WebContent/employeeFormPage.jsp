<html>
<head>
<title>New Employee</title>
</head>
<body>
	<h2>Employee Management - New Employee</h2>
	<hr />
	<form action="confirmAddEmployee" method="POST">
		<div>
			<label>Employee Id: </label> <input type="number" name="empId" />
		</div>
		<div>
			<label>Employee Name: </label> <input type="text" name="empName"
				required />
		</div>
		<div>
			<label>Gender: </label> <input type="text" name="gender" required />
		</div>
		<div>
			<label>Company Id: </label> <input type="number" name="compId"
				required />
		</div>
		<div>
			<button>Add</button>
		</div>
	</form>

	<hr />
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
		</ul>
	</nav>
</body>
</html>