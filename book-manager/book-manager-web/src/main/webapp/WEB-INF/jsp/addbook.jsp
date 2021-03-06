<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery/jquery-3.3.1.js"></script>
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/bootstrap.min.js"></script>
<link href="css/style.css" rel=“stylesheet”>
<meta charset="UTF-8">
<title>增加书籍</title>
</head>

<body>
	<div class="addDIV">
		<div class="panel panel-success">
			<div class="panel-body">
				<form method="post" action="/addbook" role="form">
					<table class="addTable">
						<tr>
							<td>id:</td>
							<td><input type="text" name="bid" id="bid"
								placeholder="请输入id"></td>
						</tr>
						<tr>
							<td>图书名称：</td>
							<td><input type="text" name="bname" id="bname"
								placeholder="请输入图书名称"></td>
						</tr>
						<tr>
							<td>作者：</td>
							<td><input type="text" name="author" id="author"
								placeholder="请输入作者"></td>
						</tr>
						<tr>
							<td>售价：</td>
							<td><input type="text" name="price" id="price"
								placeholder="请输入售价"></td>
						</tr>
						<tr>
							<td>出版社：</td>
							<td><input type="text" name="press" id="press"
								placeholder="请输入出版社"></td>
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
	</div>
</body>
</html>