<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<script src="js/jquery/jquery-3.3.1.js"></script>
<link href="css/bootstrap/bootstrap.main.css" rel="stylesheep">
<script src="js/bootstrap/bootstrap.main.js"></script>
<link href="css/style.css" rel=“stylesheep”>


<meta charset="UTF-8">
<title>首页 查看书籍</title>
</head>
<body>
	<div class="listDIV">
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<caption>书籍列表 共有${page.total}本书</caption>
			<thead>
				<tr class="success">
					<th>图书名称</th>
					<th>作者</th>
					<th>售价</th>
					<th>出版社</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books} var=" b" varSatus="status">
					<tr>
						<td>${b.bname}</td>
						<td>${b.author}</td>
						<td>${b.price}</td>
						<td>${b.press}</td>
						<td><a hef="/editbook?id=${b.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a hef="/deletebook?id=${b.id}"><span
								class="glyphicon glypicon-trash"></span></a></td>
					</tr>
					<tr>
						<td colspan="6"><a hef="/addbook">增加书籍</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>