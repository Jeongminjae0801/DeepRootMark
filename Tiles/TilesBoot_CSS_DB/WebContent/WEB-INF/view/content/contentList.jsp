<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 목록보기</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<link href="/CSS_DB/css/button.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		#tablediv table {
			padding-top: 20px;
		}
		
		.left {
			float: left;
		}
		.right {
			float: right;
		}
		.left h3 {
			margin-top: 0px;
		}
		.wall {
			margin : 40px 0px 25px 0px;
			background-color: white;
			
		}
		.col-sm-12 {
			margin-bottom: 20px;
		}
		table{
			text-align: center;
		}
		
	</style>

</head>

<script type="text/javascript">

	$(function(){
		// 검색 이벤트
		$('#search').on("click", function(){
			console.log("click");
			$.ajax({
				url: "searchContent.db",
				type: "post",
				data: {
					contentnum : $('#contentnum').val()
				},
				dataType: 'json',
				success: function(data){
					$('#tablediv').empty();
					var table = "<table class='table table-bordered'>"
					table += "<tr class='active'><td>번호</td><td>제목</td><td>테마</td><td>지역</td><td></td><td></td></tr>";
					if(data != null){
						$.each(data, function(){
							table += "<tr>"
									+ "<td>" + this.contentnum + "</td>"
									+ "<td>" + this.title + "</td>"
									+ "<td>" + this.themename + "</td>"
									+ "<td>" + this.regionname + "</td>"
									+ "<td><button type='button' seq='" + this.contentnum + "'class='btn btn-success btn-xs text modify'>수정하기</button></td>"
									+ "<td><button type='button' seq='" + this.contentnum + "'class='btn btn-danger btn-xs text delete '>삭제하기</button></td></tr>";
						});
					}else {
						table += "<tr>"
								+ "<td colspan='6'>데이터가 없습니다.</td>";
					}
					table += "</table>";
					$('#tablediv').html(table);

				}
			});
		});
	});
</script>

<body>
	<!-- header -->
	
	
	<!-- container -->
	<div class="container" style="min-height: 820px;">
		<div class="wall">
			<h2><b>글 목록</b></h2>
		</div>
		
		<div id="tablediv">
			<table class="table table-bordered">
				<tr class="active">
					<td>번호</td>
					<td>제목</td>
					<td>테마</td>
					<td>지역</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>1</td>
					<td>지금은 Tiles테스트 중입니다.</td>
					<td>Tiles</td>
					<td>비트캠프 강남점</td>
					<td><button class="btn btn-success btn-xs text modify" style="padding:2px 5px;" type="button" >수정하기</button></td>
					<td><button class="btn btn-danger btn-xs text delete" style="padding:2px 5px;" type="button" >삭제하기</button></td>
				</tr>
				<tr>
					<td>2</td>
					<td>지금은 Tiles테스트2 중입니다.</td>
					<td>Tiles</td>
					<td>비트캠프 강남 신분당점</td>
					<td><button class="btn btn-success btn-xs text modify" style="padding:2px 5px;" type="button" >수정하기</button></td>
					<td><button class="btn btn-danger btn-xs text delete" style="padding:2px 5px;" type="button" >삭제하기</button></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- footer -->
	
</body>
</html>