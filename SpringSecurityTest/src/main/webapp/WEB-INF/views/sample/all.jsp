<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>๐๋ชจ๋ ์ ๊ทผ ํ์ฉ๐all.jsp</h1>

	<sec:authorize access="isAnonymous()">
		<a href="/customLogin">๋ก๊ทธ์ธ</a>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<a href="/customLogout">๋ก๊ทธ์์</a>
	</sec:authorize>


</body>
</html>