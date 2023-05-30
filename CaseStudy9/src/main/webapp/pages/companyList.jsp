<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Company - Home</title>
</head>
<body>



	<c:choose>
		<c:when test="${company ne null and comapny.size()>0 }">
			<table border="1" width="100%">
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