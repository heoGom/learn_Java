<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 입력 폼</title>
<style type="text/css">
	.style {
		color: red;
	}
</style>
</head>
<body>
	<f:form modelAttribute="command" method="POST">
		<f:errors class="style" path="*" element="div"></f:errors>
		<label>이름<f:input path="name" type="text"/></label>
		<label>이메일<f:input path="email" type="email"/></label>
		<label>나이<f:input path="age" type="number"/></label>
		<label>기혼<f:radiobutton path="marry" value="true"/></label>
		<label>미혼<f:radiobutton path="marry" value="false"/></label>
		<input type="submit">
	</f:form>
</body>
</html>