
<html>
<head>
<title>my web app</title>
</head>
<body>
<a href="/employee/list">Employee list</a><br>
<a href="/employee/form">Add new employee</a>
<form action="/employee/save" method="post">
Employee Name:<input type="text" name="empName" value="${emp.empName}" />
Employee Salary:<input type="text" name="empSalary" value="${emp.empSalary}" />
<input type="submit"/>
</form>
</body>
</html>