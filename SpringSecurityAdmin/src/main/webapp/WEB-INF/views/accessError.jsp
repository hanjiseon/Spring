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
	<h1>권한이 없습니다!</h1>
	<h2>
		<c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}" />
	</h2>
	<h3>
		<c:out value="${msg}" />
	</h3>
</body>
</html>