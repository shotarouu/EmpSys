<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員削除画面</title>
</head>
<body>
<div style="text-align:center">
<h2>従業員削除画面</h2>
従業員番号を入力して、削除ボタンをクリックしてください。
<div style="text-align:center; color:red; font-weight:bold;">
<c:out value="${requestScope.errorMessage}"/>
<c:forEach var="message" items ="${requestScope.errorMessageList}">
	<c:out value="${message}"/><br>
</c:forEach>
</div>
<div style="text-align:center">
<form action="/system/employeeFC" method = "post">
	従業員番号：<input type="number" name="empId" value="<c:out value="${param.empId}"/>"><br>
	<button type="submit" name="buttonId" value="e401">削除</button>
</form>
</div>
<div style="text-align:right">
<form action="/system/employeeFC" method = "post">
<button type="submit" name="buttonId" value="e002">従業員管理メニューへ</button><br>
</form>
</div>
</body>
</html>