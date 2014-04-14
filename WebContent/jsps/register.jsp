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
        <s:textfield name="firstName" label="First Name "/>
        <s:textfield name="lastName" label="Last Name "/>
        <s:textfield name="userName" label="User Name" />
        <s:password name="password" label="Password" />
        <s:radio name="gender" label="Gender" list="{'Male','Female'}" />
        <s:checkboxlist list="{'Sports','Travel','Reading'}" name="hobbies" label="Hobbies" />
        <s:fielderror fieldName="hobbies"/>
        <%--Shows datepicker from 1970 to 2005 --%>
        <sd:datetimepicker name="birthDate" label="BirthDate : " displayFormat="dd/MM/yy"/>
        <s:textfield name="emailId" label="Email-Id"/>    
        <s:submit value="Register"/>
    </s:form>
</center>    
</body>
</html>
