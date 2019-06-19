<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Register Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class="container jumbotron">
<h3>Welcome to Employee Panel</h3>
<form action="register">

ID    :<input type="text" name="eid" class="form-control"/>
Name  :<input type="text" name="ename" class="form-control"/>
Salary:<input type="text" name="esal" class="form-control"/>
Dept  :<select name="edept" class="form-control">
			<option value="Null" class="form-control">--Select--</option>
			<option>DEV</option>
			<option>BA</option>
			<option>Tester</option>
       </select>
    <input type="submit" value="Register" class="btn btn-success form-control"/>
</form>
 ${msg}
 <br>
 <a href="data" class="btn btn-info">View All</a>
 </div>
</body>
</html>