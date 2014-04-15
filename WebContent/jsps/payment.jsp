<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Page</title>
</head>
Welcome <s:property value="#session.user.userName"/> <a href='<s:url action="logout"/>'>LogOut</a>
<body>
<center>
    <s:form action="makepayment">
        <s:text name="Your Total Bill is : "/><s:text name="#session['bill']"/>  
         <s:radio label= "Payment Mode " name= "mode" list="{'Cash','Card'}"/>
    <s:submit value="Select Mode"/>    
    </s:form>
</center>
</body>
</html>