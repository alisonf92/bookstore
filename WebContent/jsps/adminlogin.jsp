<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%><html>
<head>
<title>Home Page</title>
<s:head />
</head>
<body>
<h2></h2>
<hr />
<s:actionerror />
<table border="0">
	<caption style="color: green;">Admin Login Form</caption>
	<tr>
		<td><s:form action="adminloginprocess" method="post">
			<s:textfield name="adminname" label="Admin Name" />
			<s:password key="password" />
			<s:submit value="Admin Login" label="Admin Login"/>
		</s:form></td>
	</tr>
</table>
</body>
</html>