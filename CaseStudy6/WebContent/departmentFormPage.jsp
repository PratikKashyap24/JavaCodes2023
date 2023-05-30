<html>
<head>
<title>New Department</title>

</head>
<body>
	<h2>Employee Management - New Department</h2>
	<hr />
	<form action="confirmAddDepartment" method="POST">
		<div>
			<label>Department Id : </label> <input type="number" name="deptNo" />
		</div>
		<div>
			<label>Department Name: </label> <input type="text" name="deptName"
				required />
		</div>
		<div>
			<label>Employee Id: </label> <input type="number" name="empId"
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