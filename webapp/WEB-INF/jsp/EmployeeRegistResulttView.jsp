<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録結果</title>
</head>
<body>
<div style="text-align:center">
<h2>従業員登録結果画面</h2>
<div style="text-align:center; color:red; font-weight:bold;">
<c:out value="${requestScope.errorMessage}"/>
<c:forEach var="message" items ="${requestScope.errorMessageList}">
	<c:out value="${message}"/><br>
</c:forEach>
</div>
従業員番号:<c:out value="${requestScope.employee.empId}"/><br>
従業員名:<c:out value="${requestScope.employee.empName}"/><br>
部門番号:<c:out value="${requestScope.employee.departmentId}"/><br>
内線番号:<c:out value="${requestScope.employee.phone}"/><br>
</div>
<div style="text-align:right">
<form action="/system/employeeFC" method = "post">
	<button type="submit" name="buttonId" value="e002">従業員管理メニューへ</button><br>
</form>
</div>
</body>
</html>