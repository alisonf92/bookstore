<%@page import="java.util.Locale"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<center>
<%

%>
<h1>Register successful please login</h1>
<s:actionerror/>
<s:form action="login">

    <s:textfield name="userName" label="userName"/>
    <s:password name="password" label="password"/>
    
    <s:submit name="login" label="submit" action="log"/>
</s:form>
</center>
</body>