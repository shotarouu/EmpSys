<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員管理メニュー</title>
</head>
<body>
<div style="text-align:center">
<h2>従業員管理メニュー</h2> 
<form action = "/system/employeeFC" method="post">
<button type = "submit" name="buttonId" value="e100">従業員検索</button><br>
<button type = "submit" name="buttonId" value="e200">従業員登録</button><br>
<button type = "submit" name="buttonId" value="e300" >従業員変更</button><br>
<button type = "submit" name="buttonId" value="e400" >従業員削除</button><br>
<button type = "submit" name="buttonId" value="e500">従業員一覧</button><br>
</form>
</div>
</body>
</html>