<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 계산기</title>
</head>
<body>
	<form method="POST">
		<input name="num1" type="number">
		<input name="num2" type="number">
		<label><input name="operator" type="radio" value="plus">더하기</label>
		<label><input name="operator" type="radio" value="minus">빼기</label>
		<input type="submit">
	</form>
</body>
</html>