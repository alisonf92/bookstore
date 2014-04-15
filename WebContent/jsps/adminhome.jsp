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
    <s:form action="addbook">
        <s:textfield name="title" label="title "/>
        <s:textfield name="author" label="author "/>
        <s:textfield name="price" label="price" />
        <s:password name="categoryid" label="categoryid" />
         
        <s:submit value="Add Book"/>
    </s:form>
</center>    
</body>
</html>
