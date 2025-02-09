
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員更新画面</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	// scripts.js
	document.addEventListener("DOMContentLoaded", function() {
		const menuIcon = document.getElementById("menu-icon");
		const navMenu = document.getElementById("nav-menu");

		menuIcon.addEventListener("click", function() {
			navMenu.classList.toggle("active");
		});
	});
</script>
</head>
<body>
	<header>
		<div class="menu-container">
			<div class="menu-icon" id="menu-icon">
				<div class="bar"></div>
				<div class="bar"></div>
				<div class="bar"></div>
			</div>
			<nav class="nav-menu" id="nav-menu">
				<form action="/system/employeeFC" method="post">
					<button type="submit" name="buttonId" value="e100">従業員検索</button>
					<button type="submit" name="buttonId" value="e200">従業員登録</button>
					<button type="submit" name="buttonId" value="e300">従業員変更</button>
					<button type="submit" name="buttonId" value="e400">従業員削除</button>
					<button type="submit" name="buttonId" value="e500">従業員一覧</button>
				</form>
			</nav>
		</div>
	</header>
	<div style="text-align: center">
		<h2>従業員更新画面</h2>
		<div style="text-align: center; color: red; font-weight: bold;">
			<c:out value="${requestScope.errorMessage}" />
			<c:forEach var="message" items="${requestScope.errorMessageList}">
				<c:out value="${message}" />
				<br>
			</c:forEach>
		</div>
		<form action="/system/employeeFC" method="post">
			<div class="mb-3">
				<label for="empId" class="form-label">従業員番号</label> <input
					type="text" class="form-control" id="empId" name="empId"
					value="${requestScope.employee.empId}" required>
				<button type="submit" name="buttonId" value="e102">検索</button>
			</div>
			<div class="mb-3">
				<label for="empName" class="form-label">従業員名</label> <input
					type="text" class="form-control" id="empName" name="empName"
					value="${requestScope.employee.empName}">
			</div>
			<div class="mb-3">
				<label for="departmentId" class="form-label">部門番号</label> <input
					type="text" class="form-control" id="departmentId"
					name="departmentId" value="${requestScope.employee.departmentId}">
			</div>
			<div class="mb-3">
				<label for="phone" class="form-label">電話番号</label> <input
					type="text" class="form-control" id="phone" name="phone"
					value="${requestScope.employee.phone}">
			</div>
			<button type="submit" name="buttonId" value="e301">更新</button>
		</form>
		<form action="/system/employeeFC" method="post">
			<button type="submit" name="buttonId" value="e002">従業員管理メニューへ</button>
		</form>
	</div>
</body>
</html>