<html>
<head>
<title>New Company</title>
</head>
<body>
	<h2>Employee Management - New Company</h2>
	<hr />
	<form action="confirmAddCompany" method="POST">
		<div>
			<label>Company Id: </label> <input type="number" name="compId" />
		</div>
		<div>
			<label>Company Name: </label> <input type="text" name="compName"
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