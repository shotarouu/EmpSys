<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システムエラーページ</title>
</head>
<body>
	<h2>システムエラーページ</h2>
	<div style="color: red; font-weight: bold;">
	<c:out value="${requestScope.errorMessage}" />
	</div>
</body>
</html>