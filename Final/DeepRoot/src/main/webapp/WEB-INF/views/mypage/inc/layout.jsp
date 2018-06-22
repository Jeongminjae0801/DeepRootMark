<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- Latest compiled Bootstrap Common CSS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Bootstrap Common CSS END -->
    
    <!-- jQuery Confirm START -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
	<!-- jQuery Confirm END -->

	<!-- Common Script START -->
    <!-- Latest compiled JavaScript & CSS -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Script Common JavaScript & CSS END -->

	<!--  jsTree CSS & JS START -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/social/modal.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script  src="${pageContext.request.contextPath}/js/jstree.min.js"></script>
	
	<!-- Header Footer -->
    <link href="${pageContext.request.contextPath}/css/mainpage/header.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mainpage/responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mainpage/footer.css" rel="stylesheet">
    <!-- Header Footer END -->
    
	<!-- Google Icon CDN -->
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<!-- Google Icon CDN END -->


<title>my BookMark</title>
</head>
<body>
	<!-- Script -->
	<script type="text/javascript"  src="${pageContext.request.contextPath}/js/mypage/mycategory.js"></script>
	<script type="text/javascript">
	
	
 	function testing_modal(d){
 		
		var gid = d.id; // 클릭한 완료된 그룹의 id 입니다.
		
		$.ajax({
			
			url : "getCompletedTeamBookmark.do",
			type : "POST",
			data : {gid : gid},	
			dataType :"json",
			success : function(obj){
				first_data=obj;
				$('#group_bookmark_modal').jstree().deselect_all(true);			
				$("#group_bookmark_modal").jstree(true).settings.core.data = obj;
				$("#group_bookmark_modal").jstree(true).refresh();
			}	
		})
		
		$('#completedGroupModal').modal();
	} 
 	
 	// 내 북마크로 가져오기 버튼 클릭시
	function submitgroupurl(){
		
		var checked_ids = []; 
		var submit_url_ids = [];
		var submit_obj = [];
		
		checked_ids = $('#group_bookmark_modal').jstree("get_checked",null,true);
		
		// url 있는 것만 골라내기
		$.each(checked_ids,function(key,value){
			var checknode_href = $('#group_bookmark_modal').jstree(true).get_node(value).a_attr.href;
			var checknode_urlname =  $('#group_bookmark_modal').jstree(true).get_node(value).text;
			if(checknode_href != '#'){
				console.log(checknode_href);
				submit_url_ids.push(value);
				submit_obj.push({url : checknode_href , urlname : checknode_urlname , ubid: 162 });
			}
		})
		console.log(submit_obj); //[3,4]
		
		$.ajax({
		
			url : "insertGroupUrl.do",
			type : "POST",
			data : {obj : submit_obj},
			success : function(){
			}
		})
	}
	
	$(document).ready(function(){
	
	var first_data = null;

	$("#group_bookmark_modal").on('click','.jstree-anchor',function(e){
		$('#group_bookmark_modal').jstree(true).toggle_node(e.target);
		
	}).jstree({
			
			"core" : {
				"dblclick_toggle" : false,
				'data' : first_data,
				'themes':{
					'name' : 'proton',
					'responsive' : true,
					'dots' : false,
				}
			},
			"plugins" : ["checkbox" ]
			
		}).bind("loaded.jstree",function(event,data){
			console.log("ready");
			 $('#group_bookmark_modal').jstree("open_all"); 
			
		}).bind("select_node.jstree",function(event,data){
				console.log($('#group_bookmark_modal').jstree("get_checked",null,true));
		})


	
	})
	
	</script>
	
	<div id="main-header">
		<tiles:insertAttribute name="header" />
	</div>

	<div id="main">
		<tiles:insertAttribute name="content" />
	</div>

	<div id="main-footer">
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

</body>
	<!-- MY Page CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mypage/mypage.css?ver=2" />
	<!-- MY Page CSS END -->
</html>