<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Payed</title>
</head>
Welcome <s:property value="#session.user.userName"/> <a href='<s:url action="logout"/>'>LogOut</a>
<body>

<center>
<h2>Thank You for Business Please visit again</h2>
<h3>Your Receipt:</h3>
<h2><s:text name=" Recieved The Amount of   "/><s:text name="#session.bill"/> Euros  </h2>
</center>
</body>
</html>