<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	function showImage(fileCallPath) {
		// 		alert(fileCallpath);

		// set timeout (x)
		$(".bigPictureWrapper").css("display", "flex").show();

		$(".bigPicture")
				.html(
						"<img src='/display?fileName="
								+ encodeURI(fileCallPath) + "'>").animate({
					width : '100%',
					height : '100%'
				}, 1000);

	}

	$(function() {

		var regex = new RegExp("(.*?)\.(exe|sh|zip|jar|msi|com)$");
		var maxSize = 5242880;

		function checkExtensions(fileSize) {
			if (fileSize >= maxSize) {
				alert("업로드 할 수 있는 최대 파일 사이즈는 5MB 입니다~! ");
				return false;
			}
			return true;
		} // checkExtensions

		function checkFileSize(fileName) {
			if (regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드 하실 수 없습니다~!");
				return false;
			}
			return true;
		} // checkFileSize

		var cloneObj = $(".uploadDiv").clone();

		$("#uploadBtn")
				.on(
						"click",
						function(e) {
							var formData = new FormData();
							var inputFile = $("input[name='uploadFile']");
							var files = inputFile[0].files;
							var fileLength = files.length
							for (var i = 0; i < fileLength; i++) {
								if (!checkExtensions(files[i].name)) {
									return false;
								}
								if (!checkFileSize(files[i].size)) {
									return false;
								}
								formData.append("uploadFile", files[i]);
							}

							var uploadResult = $(".uploadResult ul");

							function showUploadedFile(uploadResultArr) {

								var str = "";

								$(uploadResultArr)
										.each(
												function(i, obj) {

													if (!obj.image) {

														var fileCallPath = encodeURIComponent(obj.uploadPath
																+ "/"
																+ obj.uuid
																+ "_"
																+ obj.fileName);

														var fileLink = fileCallPath
																.replace(
																		new RegExp(
																				/\\/g),
																		"/");

														str += "<li><div><a href='/download?fileName="
																+ fileCallPath
																+ "'>"
																+ "<img src='/resources/img/attach.png'>"
																+ obj.fileName
																+ "</a>"
																+ "<span data-file=\'"+fileCallPath+"\' data-type='file'> x </span>"
																+ "<div></li>"

													} else {

														var fileCallPath = encodeURIComponent(obj.uploadPath
																+ "/thumb_"
																+ obj.uuid
																+ "_"
																+ obj.fileName);

														var originPath = obj.uploadPath
																+ "\\"
																+ obj.uuid
																+ "_"
																+ obj.fileName;

														originPath = originPath
																.replace(
																		new RegExp(
																				/\\/g),
																		"/");

														str += "<li><a href=\"javascript:showImage(\'"
																+ originPath
																+ "\')\">"
																+ "<img src='display?fileName="
																+ fileCallPath
																+ "'></a>"
																+ "<span data-file=\'"+fileCallPath+"\' data-type='image'> x </span>"
																+ "<li>";
													}
												});
								uploadResult.append(str);
							}

							$.ajax({
								url : '/uploadAjaxAction',
								processData : false, // 데이터 처리
								contentType : false, // MIME타입 (application/xml...)
								data : formData, // 요청시 전송 데이터
								type : "post", //  HTTP Method
								dataType : "json", // 응답시 전송 받는 데이터의 타입
								success : function(result) { // result: 응답 데이터
									console.log(result);

									showUploadedFile(result);

									$(".uploadDiv").html(cloneObj.html());

								}
							}); // ajax
						});

		$(".uploadResult").on("click", "span", function(e) {

			var targetFile = $(this).data("file");
			var type = $(this).data("type");
			console.log(targetFile);

			$.ajax({
				url : '/deleteFile',
				data : {
					fileName : targetFile,
					type : type
				},
				dataType : 'text',
				type : 'POST',
				success : function(result) {
					alert(result);
				}
			}); //$.ajax

		});
	});
</script>
<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}

.uploadResult il li span {
	width: 100px;
}

.bigPictureWrapper {
	position: absolute;
	display: none;
	justify-content: center;
	align-items: center;
	top: 0%;
	width: 100%;
	height: 100%;
	background-color: gray;
	z-index: 100;
}

.bigPicture {
	position: relative;
	display: flex;
	justify-content: center;
	align-items: center;
}

.bigPicture img {
	width: 600px;
}
</style>

</head>
<body>
	<h1>Upload With Ajax</h1>

	<div class='bigPictureWrapper'>
		<div class='bigPicture'></div>
	</div>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple />
	</div>

	<div>
		<button id="uploadBtn">upload</button>
	</div>

	<div class='uploadResult'>
		<ul>
		</ul>
	</div>


</body>
</html>