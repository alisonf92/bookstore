<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>
Welcome <s:property value="#session.user.userName"/> <a href='<s:url action="logout"/>'>LogOut</a>

<center>
    <table border="2">
        <thead>Select Category</thead>
        <s:form action="showbooks">
            <tr><td>
<s:select name="category" list="#session['categoryList']" listValue="categoryName" 
listKey="categoryId"/>
            </td></tr>
            <s:submit value="Select"/>
        </s:form>
    </table>
</center>
</body>
</html>>