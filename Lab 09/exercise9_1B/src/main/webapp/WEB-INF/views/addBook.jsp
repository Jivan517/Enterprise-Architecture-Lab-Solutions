<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<form:form modelAttribute = "book" action="../books/add" method="post">
	
	<table>
		<tr>
			<td>Title:</td>
			<td><form:input path="title" /> </td>
			<td><form:errors path = "title" cssStyle="color:red"/> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><form:input path="ISBN" /> </td>
			<td><form:errors path = "ISBN" cssStyle="color:red"/> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><form:input path="author" /> </td>
			<td><form:errors path = "author" cssStyle="color:color:red"/> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="price" /> </td>
			<td><form:errors path = "price" cssStyle="color:red" /> </td>
		</tr>
		<tr>
			<td>Published Date:</td>
			<td><form:input path="publishedDate" /> </td>
			<td><form:errors path = "publishedDate" cssStyle="color:red" /> </td>
		</tr>
		
	</table>
	<input type="submit" value = "add"/>
	
	</form:form>
</body>
</html>