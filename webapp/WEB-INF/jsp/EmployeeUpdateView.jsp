<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員更新録画面</title>
</head>
<body>
<div style="text-align:center">
<h2>従業員更新画面</h2>
<div style="text-align:center; color:red; font-weight:bold;">
<c:out value="${requestScope.errorMessage}"/>
<c:forEach var="message" items ="${requestScope.errorMessageList}">
	<c:out value="${message}"/><br>
</c:forEach>
</div>
<form action="/system/employeeFC" method = "post">
	<div class="mb-3">
		    <label for="empId" class="form-label">従業員番号</label>
		    <input type="text" class="form-control" id="empId" name="empId" value="${requestScope.employee.empId}" required>
		    <button type="submit" name="buttonId" value="e102">検索</button>
	</div>
	<div class="mb-3">
		    <label for="empName" class="form-label">従業員名</label>
		    <input type="text" class="form-control" id="empName" name="empName"  value="${requestScope.employee.empName}" >
	</div>
	<div class="mb-3">
		    <label for="departmentId" class="form-label">部門番号</label>
		    <input type="text" class="form-control" id="departmentId" name="departmentId"  value="${requestScope.employee.departmentId}" >
	</div>
	<div class="mb-3">
		    <label for="phone" class="form-label">電話番号</label>
		    <input type="text" class="form-control" id="phone" name="phone" value="${requestScope.employee.phone}">
	</div>
	<button type="submit" name="buttonId" value="e301">更新</button>
	<button type="submit" name="buttonId" value="e002">従業員管理メニューへ</button><br>
</form>
</div>	
</body>
</html>