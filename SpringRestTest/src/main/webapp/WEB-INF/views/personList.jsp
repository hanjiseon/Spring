
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>나이</th>
					</tr>
				</thead>

				<c:forEach items="${PersonList}" var="person">
					<tr>
						<td><c:out value="${person.pid}" /></td>
						<td><c:out value="${person.pname}" /></td>
						<td><c:out value="${person.page}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>