<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Employee Page</title>
<style type="text/css">

body {
	background-color:teal;
}
td {
	color: white;
}
</style>
</head>
<body>
	
    <div align="center" style="margin-top: 80px;">
	<form:form method="POST" modelAttribute="employee">
     
   <table>
   
<tr>
<td><form:label path="empId">Employee Id</form:label></td>
<td><form:input type="number" path="empId" /></td>
<td><form:errors path="empId"></form:errors></td>
</tr>
<tr>
<td><form:label path="empName">Employee Name</form:label></td>
<td><form:input type="text" path="empName" /></td>
<td><form:errors path="empName"></form:errors></td>
</tr>
<tr>
<td><form:label path="gender">Gender</form:label></td>
<td><form:input type="text" path="gender" /></td>
<td><form:errors path="gender"></form:errors></td>
</tr>
<tr>
<td><form:label path="compId">Company Id</form:label></td>
<td><form:input type="number" path="compId" /></td>
<td><form:errors path="compId"></form:errors></td>
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