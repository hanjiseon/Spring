<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form name="frm" action="/test/fileupload" method="post">
		<input type="file" name="uploadFile" /><br />
		<input type="file" name="uploadFile" /><br />
		<input type="file" name="uploadFile" /><br />
		<input type="button" value="업로드" onclick="frm.submit();" />
	</form>
	</div>
</body>
</html>