<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(function(){
		$("#userListTable").DataTable();
	});
	
	function deleteUser(uid) {
		
	};
</script>

<!-- Main Content START -->
<div class="content-wrapper" style="min-height: 913px;">
	<section class="content-header">
		<h1>User List</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:;"><i class="fa fa-home"></i>Home</a></li>
			<li class="active">user list</li>
		</ol>
	</section>
	<!--userList table start-->

	<section class="content">
		<div id="page-wrapper">
			<br>
			<div class="row">
				<div class="col-lg-8">
					<div class="panel">
						<div class="panel-heading">회원목록</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%" class="table table-hover" id="userListTable">
								<thead>
									<tr>
										<th>Name</th>
										<th>Email</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${userlist}" var="user">
									<tr>
										<td>${user.nname}</td>
										<td>${user.uid}</td>
										<td><input class="btn btn-danger" type="button"
											value="삭제" onclick="deleteUser(${user.uid})"></td>
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
		<!--userList table end-->
	</section>
</div>
<!-- Main Content END -->