<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 페이지 전환 Script START -->
<script type="text/javascript">
	$(document).ready(function() {
    	$('#groupListTable').DataTable({
			responsive: true
		});
    });

	/*그룹삭제 임시 스크립트 START*/
	function deleteGroup(gid) {
		if (confirm('삭제하시겠습니까?')) {
			$("#"+gid).remove();
			
			/* var clickedRow = $(this).parent();
			clickedRow.remove(); */
			} else {
				return;
			}
	}
    /*그룹삭제 임시 스크립트 END*/
</script>
<!-- 페이지 전환 Script END -->

<!-- Main Content START -->
<div class="content-wrapper" style="min-height: 913px;">
	<section class="content-header">
		<h1>Group List</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:;"><i class="fa fa-home"></i>Home</a></li>
			<li class="active">group list</li>
		</ol>
	</section>
	<!--groupList table start-->
	<section class="content">
		<div id="page-wrapper">
			<br>
			<div class="row">
				<div class="col-lg-8">
					<div class="panel">
						<div class="panel-heading">그룹목록 테이블</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%" class="table table-hover" id="groupListTable">
								<thead>
									<tr>
										<th>GroupId</th>
										<th>GroupName</th>
										<th>GroupHashTag</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${grouplist}" var="group">
									<tr id="${group.gid}">
										<td>${group.gid}</td>
										<td>${group.gname}</td>
										<td>${group.htag}</td>
										<td><input class="btn btn-danger" type="button"
											value="삭제" onclick="deleteGroup(${group.gid})"></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
		<!--groupList table end-->
	</section>
</div>
<!-- Main Content END -->