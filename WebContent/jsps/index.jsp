<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<center>
<table border="2">
<tr><td><a href='<s:url action="gotologin"/>'>Login</a></td></tr>
<tr><td><a href='<s:url action="gotoregister"/>'>Register Here</a></td></tr>

<tr><td><a href='<s:url action="gotoadmin"/>'>Admin Login</a></td></tr>

</table>
</center>
</body>
</html>