
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Details</title>
</head>
Welcome <s:property value="#session.user.userName"/> <a href='<s:url action="logout"/>'>LogOut</a>
<body>
<s:form action="thankyou">
    <s:if test="#session.mode.equals('Cash')">
        <s:text name=" Make Cash Payment"/>
        <s:textfield label="Amount : " name="amount" value="%{#session['bill']}" 
        readonly="true"/>
    </s:if>
    <s:else>
        <s:text name="Make Card Payment"/>
        <s:textfield label="Amount : " name="amount" value="%{#session['bill']}" 
        readonly="true"/>
        <s:textfield label="Card No. : " name="cardNo"/>
    </s:else>
    <s:submit value="Pay"/>
</s:form>
</body>
</html>
