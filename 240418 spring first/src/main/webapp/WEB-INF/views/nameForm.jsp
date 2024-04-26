<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 입력</title>
</head>
<body>
	<form method="POST">
		<input name="firstName" type="text">${ firstNameError }
		<input name="lastName" type="text">${ lastNameError }
		<input type="submit">
	</form>
</body>
</html>