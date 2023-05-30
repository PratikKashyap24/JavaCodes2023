<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Company - Home</title>
<style type="text/css">

body {
	background-color:teal;
}
td,th,h1{
	color: white;
	text-align: center;
}
h1{
text-decoration: underline;
}

</style>
</head>
<body>
<h1 >
Company List
</h1>


	<c:choose>
		<c:when test="${company ne null and company.size()>0 }">
			<table border="1" width="100%" style="border-color: white">
				<tr>
					<th>Company Id</th>
					<th>Company Name</th>



				</tr>
				<c:forEach items="${company }" var="company">
					<tr>
						<td>${company.compId }</td>
						<td>${company.compName }</td>



					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>
				<strong>No Company Found!</strong>
		</c:otherwise>
	</c:choose>
    
	<jsp:include page="/footer" />
</body>
</html>