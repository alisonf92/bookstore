<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selected Books</title>
</head>
Welcome <s:property value="#session.user.userName"/> <a href='<s:url action="logout"/>'>LogOut</a>
<body>
<s:form action="purchase" theme="simple">
    <center>
        <table border=2>
        <tr><td>Book Name</td><td>Book Price</td></tr>
        <s:iterator value="#session['currSelected']">
            <tr><td><s:property value="bookName"/></td>
            <td><s:property value="bookPrice"/></td></tr>
        </s:iterator>
        <tr><td><s:text name="Current Bill : "/></td>
        <td><s:text name="#session['bill']"/> </td></tr>
        <tr><td><s:submit value="Purchase"/> </td>
        <td><a href="jsps/category.jsp">More Books</a></td></tr>
        </table>
    </center>
</s:form>
</body>
</html>
