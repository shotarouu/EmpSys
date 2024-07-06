<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<div style="text-align: center">
		<h2>ログイン</h2>
		<div style="color:red; font-weight: bold;">
			<c:out value="${requestScope.errorMessage}" />
		</div>
		<div>
			<form action="/system/employeeFC"  method = "post">
				従業員番号：<input type="number" name="empId" value="<c:out value="${param.empId}" />">	<br> 
					パスワード：<input type="password" name="password" value="<c:out value="${param.password}" />"><br> 
					<button type="submit" name="buttonId" value="e001">ログイン</button>
			</form>
		</div>
	</div>
</body>
</html>