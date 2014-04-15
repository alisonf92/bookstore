<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="book">
<s:textfield name="book.title" label="Book Name"/>
<s:textfield name="book.categoryid" label="Category ID"/>
<s:textfield name="book.price" label="Book Price"/>
<s:submit value="add" action="addBook"/>
<s:submit value="update" action="updateBook"/>
<s:submit value="delete" action="deleteBook"/>
</s:form>
</body>
</html>