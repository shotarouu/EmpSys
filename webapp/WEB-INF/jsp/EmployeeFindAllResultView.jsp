<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報一覧</title>
</head>
<body>
<div style="text-align:center">
<h2>従業員情報一覧</h2>
<div style="text-align:center; color:red; font-weight:bold;">
<c:out value="${requestScope.errorMessage}"/>
<c:forEach var="message" items ="${requestScope.errorMessageList}">
	<c:out value="${message}"/><br>
</c:forEach>
</div>
<table border="1" style="margin:0 auto">
<tr>
<th>従業員ID</th>
<th>従業員名</th>
<th>部署ID</th>
<th>電話番号</th>
</tr>
<c:forEach var="employee" items ="${requestScope.empList}">
<tr>
<td><c:out value="${employee.empId}"/></td>
<td><c:out value="${employee.empName}"/></td>
<td><c:out value="${employee.departmentId}"/></td>
<td><c:out value="${employee.phone}"/></td>
</tr>
</c:forEach>
</table>
<div style="text-align:right">
<form action="/system/employeeFC" method = "post">
	<button type="submit" name="buttonId" value="e002">従業員管理メニューへ</button><br>
</form>
</div>	
</body>
</html>