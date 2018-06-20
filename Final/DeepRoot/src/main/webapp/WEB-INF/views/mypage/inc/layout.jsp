<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--  CSS START -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/dist/themes/proton/style.css" />

<!-- Font Awesome CSS STARAT -->
<link rel="stylesheet" href=https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css>

 <!-- Font Awesome CSS END -->

<!--  -->
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Header Footer -->
    <link href="../css/mainpage/header.css" rel="stylesheet">
    <link href="../css/mainpage/footer.css" rel="stylesheet">

<!-- Google Icon CDN -->
 <link  rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- Google Icon CDN END -->

<!-- Script START -->
<script 	src="${pageContext.request.contextPath}/resources/assets/jquery-1.10.2.min.js"></script>
<script 	src="${pageContext.request.contextPath}/resources/assets/dist/jstree.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>

<!-- Script END -->

<!-- jQuery Confirm START -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
<!-- jQuery Confirm END -->

<title>my BookMark</title>
</head>
<body>

<!-- Script -->
<script src="../js/mypage/mycategory.js"></script>
	
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>

	<div id="main">
		<tiles:insertAttribute name="content" />
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>



	<div class="modal fade" id="linkAdd" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<b>URL 추가</b>
					</h4>
				</div>

				<div class="modal-body">
					<form id="form">
						<table class="table">
							<colgroup>
								<col width="30%">
								<col width="70%">
							</colgroup>
							<tr>
								<td class="info" style="vertical-align: middle;">URL :</td>
								<td><input type="text" id="url" name="url"
									class="form-control"></td>
							</tr>
							<tr>
								<td class="info" style="vertical-align: middle;">제목 :</td>
								<td><input type="text" id="title" name="title"
									class="form-control"></td>
							</tr>
							<tr>
								<td class="info" style="vertical-align: middle;">해시태그 :</td>
								<td><input type="text" id="htag" name="htag"
									class="form-control"></td>
							</tr>
							<tr>
								<td class="info" style="vertical-align: middle;">공유제목 :</td>
								<td><input type="text" id="sname" name="sname"
									class="form-control"></td>
							</tr>
							<tr>
								<td><input type="checkbox" id="share"> <label
									for="share">공유하기</label></td>
								<td></td>
							</tr>
						</table>
					</form>
					<div class="modal-footer">
						<!-- type="submit" value="Submit" -->
						<button type="button" class="btn btn-default btn-sm"
							data-dismiss="modal">취소</button>
						<button class="btn btn-default btn-sm" id="linkAddSubmit">추가하기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
		<div class="modal fade" id="linkAdd_btn" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<b>URL 추가</b>
					</h4>
				</div>

				<div class="modal-body">
					<form id="form_btn">
						<table class="table">
							<colgroup>
								<col width="30%">
								<col width="70%">
							</colgroup>
							<tr>
								<td class="info" style="vertical-align: middle;">URL :</td>
								<td><input type="text" id="url_btn" name="url_btn"
									class="form-control"></td>
							</tr>
							<tr>
								<td class="info" style="vertical-align: middle;">제목 :</td>
								<td><input type="text" id="title_btn" name="title_btn"
									class="form-control"></td>
							</tr>
							<tr>
								<td class="info" style="vertical-align: middle;">해시태그 :</td>
								<td><input type="text" id="htag_btn" name="htag_btn"
									class="form-control"></td>
							</tr>
							<tr>
								<td class="info" style="vertical-align: middle;">공유제목 :</td>
								<td><input type="text" id="sname_btn" name="sname_btn"
									class="form-control"></td>
							</tr>
							<tr>
								<td><input type="checkbox" id="share"> <label
									for="share">공유하기</label></td>
								<td></td>
							</tr>
						</table>
					</form>
					<div class="modal-footer">
						<!-- type="submit" value="Submit" -->
						<button type="button" class="btn btn-default btn-sm"
							data-dismiss="modal">취소</button>
						<button class="btn btn-default btn-sm" id="linkAddSubmit_btn">추가하기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	

	<div class="modal fade" id="folderAdd" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<b>폴더 추가</b>
					</h4>
				</div>

				<div class="modal-body">
					<form id="form2">
						<table class="table">
							<colgroup>
								<col width="30%">
								<col width="70%">
							</colgroup>
							<tr>
								<td class="info" style="vertical-align: middle;">폴더 이름</td>
								<td><input type="text" id="foldername" name="foldername"
									class="form-control"></td>
							</tr>
						</table>
					</form>
					<div class="modal-footer">
						<!-- type="submit" value="Submit" -->
						<button type="button" class="btn btn-default btn-sm"
							data-dismiss="modal">취소</button>
						<button class="btn btn-default btn-sm" id="folderAddsubmit">추가하기</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="editurl" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<b>URL 변경</b>
					</h4>
				</div>

				<div class="modal-body">
					<form id="form3">
						<table class="table">
							<colgroup>
								<col width="30%">
								<col width="70%">
							</colgroup>
							<tr>
								<td class="info" style="vertical-align: middle;">URL</td>
								<td><input type="text" id="editurlval" name="editurlval"
									class="form-control"></td>
							</tr>
						</table>
					</form>
					<div class="modal-footer">
						<!-- type="submit" value="Submit" -->
						<button type="button" class="btn btn-default btn-sm"
							data-dismiss="modal">취소</button>
						<button class="btn btn-default btn-sm" id="editurlsubmit">수정하기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
<i class="jstree-icon jstree-themeicon jstree-themeicon-custom" role="presentation" style="background-image: url(&quot;https://www.google.com/s2/favicons?domain=https://colorscripter.com/&quot;); background-position: center center; background-size: auto;"></i>

</body>
<!-- MY Page CSS -->
<link rel="stylesheet" href="../css/mypage/mypage.css?ver=2" />
<!-- MY Page CSS END -->
</html>