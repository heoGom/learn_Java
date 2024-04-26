<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인적 정보 (서버사이드 렌더링)</title>
</head>
<body>
	<c:if test="${ not empty findPage.content }">
		<c:forEach var="person" items="${ findPage.content }">
			<p>${person.name} : ${person.age}</p>
		</c:forEach>
	</c:if>
	<c:forEach var="i" begin="0" end="${ findPage.totalPages - 1}">
		<c:url var="url" value="/person">
			<c:param name="page">${i}</c:param>
		</c:url>
		<a href="${url}">${i + 1}</a>
	</c:forEach>
</body>
</html>