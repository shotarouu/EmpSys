<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録結果</title>
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
		<h2>従業員登録結果画面</h2>
		<div style="text-align: center; color: red; font-weight: bold;">
			<c:out value="${requestScope.errorMessage}" />
			<c:forEach var="message" items="${requestScope.errorMessageList}">
				<c:out value="${message}" />
				<br>
			</c:forEach>
		</div>
		従業員番号:
		<c:out value="${requestScope.employee.empId}" />
		<br> 従業員名:
		<c:out value="${requestScope.employee.empName}" />
		<br> 部門番号:
		<c:out value="${requestScope.employee.departmentId}" />
		<br> 内線番号:
		<c:out value="${requestScope.employee.phone}" />
		<br>
	</div>
	<div style="text-align: right">
		<form action="/system/employeeFC" method="post">
			<button type="submit" name="buttonId" value="e002">従業員管理メニューへ</button>
			<br>
		</form>
	</div>
</body>
</html>