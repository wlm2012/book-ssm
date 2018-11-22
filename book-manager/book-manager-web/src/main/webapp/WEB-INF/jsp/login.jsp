<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery/jquery-3.3.1.js"></script>
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/bootstrap.min.js"></script>
<link href="css/style.css" rel=“stylesheet”>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<div class="panel panel-success">
		<div class="panel-body">
			<form action="/login" method="post">
				<table class="editTable">
					<tr>
						<td>帐号：</td>
						<td><input type="text" name="loginname" id="loginname"
							placeholder="请输入帐号"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="text" name="loginpassword" id="loginpassword"
							placeholder="请输入密码"></td>
					</tr>
					<tr class="submitTR">
					<td colspan="2" align="center">
					<button type="submit" class="btn btn-success">提交</button>
					</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>