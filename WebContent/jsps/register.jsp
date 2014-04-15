<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--Must be done in order for dojo tags to work --%>

<sd:head parseContent="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
<center>
<s:actionerror/>    
    <s:form action="register">

        <s:textfield name="name" label="Name "/>
        <s:textfield name="address" label="Address "/>

        <s:checkboxlist list="{'Sports','Travel','Reading'}" name="interests" label="Interests" />
        <s:fielderror fieldName="interests"/>
        <s:textfield name="email" label="Email-Id"/>  
        <s:textfield name="cardnumber" label="CardNumber"/>  
        <s:textfield name="userName" label="User Name" />
        <s:password name="password" label="Password" />  

        <s:submit value="Register"/>
    </s:form>
</center>    
</body>
</html>
