<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Detail</title>
</head>
<body>
<form action="../books/${book.id}" method="post">
	<table>
		<tr>
			<td>Title:</td>
			<td><input type="text" name="title" value="${book.title}" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" name="author" value="${book.author}" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" value="${book.price}" /> </td>
		</tr>
		<tr>
			<td>Published Date:</td>
			<td><input type="text" name="publishedDate" value="${book.publishedDate}" /> </td>
		</tr>
		
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?bookId=${book.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>