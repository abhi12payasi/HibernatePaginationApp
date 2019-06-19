<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<title>Employee Data Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class=" container jumbotron">
<h3>Welcome to data page</h3>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Department</th>
		</tr>
		<c:forEach items="${emps}" var="emp">
			<tr>
				<td><c:out value="${emp.getEmpId()} " /></td>
				<td><c:out value="${emp.getEmpName()} " /></td>
				<td><c:out value="${emp.getEmpSal()} " /></td>
				<td><c:out value="${emp.getEmpDept()} " /></td>
			</tr>
		</c:forEach>
	</table><br>
	<a href="data?pn=1">First</a>
	<c:forEach begin="1" end="${nps}" var="i">
		<a href="data?pn=${i}">${i}</a> &nbsp;
	</c:forEach>
	<a href="data?pn=${nps}">Last</a>
	</div>
</body>
</html>