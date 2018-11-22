<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<script src="js/jquery/jquery-3.3.1.js"></script>
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/bootstrap.min.js"></script>
<link href="css/style.css" rel=“stylesheet”>


<meta charset="UTF-8">
<title>首页 查看书籍</title>
</head>
<body>
	<div class="listDIV">
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<caption>书籍列表 共有${page.total}本书  <a href="/logout"> 登出</a></caption>
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
				<c:forEach items="${books}" var="b" varStatus="status">
					<tr>
						<td>${b.bname}</td>
						<td>${b.author}</td>
						<td>${b.price}</td>
						<td>${b.press}</td>
						<td><a href="/editbook?id=${b.bid}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a href="/deletebook?id=${b.bid}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" align="center"><a href="/addbook1">增加</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<nav class="pageDIV">
		<ul class="pagination">
			<li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
				<a href="?page.start=0"> <span>«</span>
			</a>
			</li>

			<li <c:if test="${!page.hasPreviouse}">class="disables"</c:if>>
				<a href="?page.start=${page.start-page.count }"> <span>‹</span>
			</a>
			</li>

			<c:forEach begin="0" end="${page.totalPage-1 }" varStatus="status">
				<c:if
					test="${status.count*page.count-page.start <=30 && status.count*page.count-page.start >=-10}">
					<li
						<c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
						<a href="?page.start=${status.index*page.count }"
						<c:if test="status.index*page.count==page.start">class="current"</c:if>>${status.count}</a>
					</li>
				</c:if>
			</c:forEach>
			<li <c:if test="${!page.hasNext }">class="disabled"</c:if>><a
				href="?page.start=${page.start+page.count }"> <span>›</span>
			</a></li>
			<li <c:if test="${!page.hasNext }">class="disabled"</c:if>><a
				href="?page.start=${page.last}"> <span>»</span>
			</a></li>
		</ul>
	</nav>
</body>
</html>