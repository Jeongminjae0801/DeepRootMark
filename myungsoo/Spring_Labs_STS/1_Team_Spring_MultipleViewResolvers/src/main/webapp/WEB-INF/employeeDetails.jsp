<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Via JSP View Resolver</title>
	</head>
	<body>
		<h1>InternalResourceView</h1>
		<!-- Retrieve the model data through JSTL -->
		<p><strong>Employee ID:</strong> ${employee.empId}</p>
		<p><strong>Employee Name:</strong> ${employee.name}</p>
	</body>
</html>