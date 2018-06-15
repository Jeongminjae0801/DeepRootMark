<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- adminTable CSS START -->
<link rel="stylesheet" href="/bit/css/admin/adminTable.css">
<link rel="stylesheet" href="/bit/css/admin/dataTables.bootstrap.css">
<link rel="stylesheet" href="/bit/css/admin/mainbooklist.css">
<link rel="stylesheet" href="/bit/css/admin/colorPick.css">
<!-- adminTable CSS END -->

<script>
	$(function(){
		dataTable();
	});
	
	function dataTable() {
    	$.ajax({
    		url : "/bit/categoryList.do",
    		type : "POST",
    		success : function(data) {
    			//console.log(data); // 카테고리 리스트 확인 콘솔
    			$.each(data, function(index, element) {
    				$.each(element, function(index2, element2){
    					$('table[id="'+ element2.acname + '"]').dataTable();
    				});
    			});
    		},
    		error: function (error) {
    		    alert('error : ' + eval(error));
    		}
    	});
    };
</script>



<!-- Main Content START -->
<div class="content-wrapper" style="min-height: 913px;">
	<section class="content-header">
		<h1>
			Main Bookmark List
			<!-- Category insert / Delete START -->
			<span class="btn-category" data-toggle="dropdown"><i
				class="fa fa-th-list category-dropdown"></i></span>
			<ul class="dropdown-menu category">
				<li><a data-toggle="modal" onclick="openCategoryModal();">카테고리
						추가<i class="fa fa-plus"></i>
				</a></li>
				<li><a data-toggle="modal" onclick="openCategoryDeleteModal();">카테고리
						삭제<i class="fa fa-minus"></i>
				</a></li>
			</ul>
			<!-- Category inert / Delete END -->
		</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:;"><i class="fa fa-home"></i>Home</a></li>
			<li class="active">main bookmark list</li>
		</ol>
	</section>

	<!-- Category lsit Dropdown START -->
	<section class="content-category">
		<div class="row">
			<div class="col-sm-12 category">
				<!-- Category lsit Dropdown START -->
				<button class="btn-category categorylist" data-toggle="dropdown"
					type="button">
					카테고리<i class="fa fa-caret-right"></i>
				</button>
				<ul class="dropdown-menu categorylist">
					<c:forEach items="${categorylist}" var="category">
						<li><a href="#${category.acname}">${category.acname}</a></li>
					</c:forEach>
				</ul>
				<!-- Category lsit Dropdown END -->
			</div>
		</div>
	</section>
	<!-- Category lsit Dropdown END -->

	<!--groupList table start-->
	<section class="content">
		<div id="page-wrapper">
			<div class="row">
				<!-- Category List Table START -->
				<c:forEach items="${url_by_category}" var="hashmap">
					<div class="col-sm-6">
						<div class="panel">
							<!-- Category Name & edit & insert START -->

							<div class="panel-heading">
								<span id="${hashmap.key}"> ${hashmap.key}</span>
								<!--color picker START -->
								<button class="colorPickSelector"></button>
								<!--color picker END -->
								<i class="fa fa-pencil" data-toggle="modal"
									onclick="openCategoryEditModal();"></i>
								<div class="pull-right">
									<i class="fa fa-plus-circle i-plus-circle" data-toggle="modal"
										onclick="openUrlModal();"></i>
								</div>
							</div>
							<!-- /.panel-heading -->

							
								<!-- Category Name & edit & insert END -->
								<div class="panel-body">
								<table width="100%" class="table table-hover" id="${hashmap.key}">
									<thead>
										<tr>
											<th>사이트명</th>
											<th>URL 주소</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${hashmap.value}" var="book">
										<tr>
											<td>${book.urlname}</td>
											<td><a href="${book.url}" target="_blank">${book.url}</a></td>
											<td><i class="fa fa-pencil url-action" onclick=""></i><i
												class="fa fa-trash-o url-action" onclick="deleteGroup(${book.abid})"></i>
											</td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
		<!--categoryModal script start-->
		<script>
                        /*카테고리 추가 모달 바로열기*/
                        function showCategoryForm() {
                            $('.addCategoryBox').fadeIn('fast');
                            $('.addCategory-footer').fadeIn('fast');
                            $('.modal-title').html('카테고리 추가');
                        }


                        function openCategoryModal() {
                            showCategoryForm();
                            setTimeout(function() {
                                $('#addCategoryModal').modal('show');
                            }, 230);

                        }
                    </script>
		<!--categoryModal script end-->

		<!--categoryModal start-->
		<div class="modal fade addCategory" id="addCategoryModal">
			<div class="modal-dialog">

				<div class="modal-content">
					<form name="addCategory" method="post" action="/addCategory"
						accept-charset="UTF-8">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title"></h4>
						</div>

						<div class="modal-body">
							<div class="box">
								<!--카테고리명 입력-->
								<div class="form addCategoryBox">
									<label class="control-label" for="acname">추가할 카테고리명을
										입력하세요</label> <input id="acname1" class="form-control" type="text"
										placeholder="acname" name="acname" /><br>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<div class="addCategory-footer">
								<input class="btn btn-default btn-comp" type="button" value="등록"
									onclick="">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--categoryModal end-->

		<!--categoryEditModal script start-->
		<script>
                        /*카테고리 수정 모달 바로열기*/
                        function showCategoryEditForm() {
                            $('.editCategoryBox').fadeIn('fast');
                            $('.editCategory-footer').fadeIn('fast');
                            $('.modal-title').html('카테고리 수정');
                        }

                        function openCategoryEditModal() {
                            showCategoryEditForm();
                            setTimeout(function() {
                                $('#editCategoryModal').modal('show');
                            }, 230);
                        }
                    </script>
		<!--categoryEditModal script end-->

		<!--categoryEditModal start-->
		<div class="modal fade editCategory" id="editCategoryModal">
			<div class="modal-dialog">

				<div class="modal-content">
					<form name="editCategory" method="post" action="/editCategory"
						accept-charset="UTF-8">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title"></h4>
						</div>

						<div class="modal-body">
							<div class="box">
								<!--카테고리명 입력-->
								<div class="form editCategoryBox">
									<label class="control-label" for="acnameList">수정할 카테고리를
										선택하세요</label>&nbsp; <select id="acnameList" class="form-control"
										name="acnameList">
										<option>포털사이트</option>
										<option>서칭</option>
									</select><br> <br> <label class="control-label" for="acname">카테고리명을
										입력하세요</label> <input id="acname2" class="form-control" type="text"
										placeholder="acname" name="acname"><br>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<div class="editCategory-footer">
								<input class="btn btn-default btn-comp" type="button" value="등록"
									onclick="">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--categoryEditModal end-->

		<!--categoryDeleteModal script start-->
		<script>
                        /*카테고리 삭제 모달 바로열기*/
                        function showCategoryDeleteForm() {
                            $('.deleteCategoryBox').fadeIn('fast');
                            $('.deleteCategory-footer').fadeIn('fast');
                            $('.modal-title').html('카테고리 삭제');
                        }

                        function openCategoryDeleteModal() {
                            showCategoryDeleteForm();
                            setTimeout(function() {
                                $('#deleteCategoryModal').modal('show');
                            }, 230);

                        }
                    </script>
		<!--categoryDeleteModal script end-->

		<!--categoryDeleteModal start-->
		<div class="modal fade deleteCategory" id="deleteCategoryModal">
			<div class="modal-dialog">

				<div class="modal-content">
					<form name="deleteCategory" method="post" action="/deleteCategory"
						accept-charset="UTF-8">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title"></h4>
						</div>

						<div class="modal-body">
							<div class="box">
								<!--카테고리명 입력-->
								<div class="form deleteCategoryBox">
									<label class="control-label" for="acnameList2">삭제할
										카테고리를 선택하세요</label>&nbsp; <select id="acnameList2"
										class="form-control" name="acnameList">
										<option>포털사이트</option>
										<option>서칭</option>
									</select><br> <input id="acname3" class="form-control"
										type="hidden" name="acname"><br>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<div class="deleteCategory-footer">
								<input class="btn btn-default btn-comp" type="button" value="확인"
									onclick="">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--categoryDeleteModal end-->

		<!--urlAddModal script start-->
		<script>
                        /*URL 추가 1단계 모달*/
                        function showUrlForm() {
                            $('.categoryBox').fadeOut('fast', function() {
                                $('.addUrlBox').fadeIn('fast');
                                $('.category_unshared-footer').fadeOut('fast', function() {
                                    $('.url-footer').fadeIn('fast')
                                })
                            });
                            $('.modal-title').html('1단계');

                        }
                        /*URL 추가 2단계 모달*/
                        function showUrlStep2Form() {
                            $('.addUrlBox').fadeOut('fast', function() {
                                $('.categoryBox').fadeIn('fast');
                                $('.url-footer').fadeOut('fast', function() {
                                    $('.category_unshared-footer').fadeIn('fast')

                                });
                            });
                            $('.modal-title').html('2단계');

                        }

                        /*URL 추가 1단계 모달 바로열기*/
                        function openUrlModal() {
                            showUrlForm();
                            setTimeout(function() {
                                $('#addUrlModal').modal('show');
                            }, 230);

                        }
                    </script>

		<!--urlAddModal script end-->
		<!--urlAddModal start-->

		<div class="modal fade addUrl" id="addUrlModal">
			<div class="modal-dialog">

				<div class="modal-content">
					<form name="addUrl" method="post" action="/addUrl"
						accept-charset="UTF-8">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title"></h4>
						</div>

						<div class="modal-body">
							<div class="box">
								<!--1단계 URL 입력-->
								<div class="form addUrlBox">
									<label class="control-label" for="url">URL을 입력하세요</label> <input
										id="url" class="form-control" type="text" placeholder="URL"
										name="url"><br>
								</div>
							</div>

							<div class="box">
								<!--2단계 카테고리 선택-->
								<div class="categoryBox" style="display: none;">
									<div class="form">
										<label class="control-label" for="urlname">제목</label> <input
											id="urlname" class="form-control" type="text"
											placeholder="URLNAME" name="urlname"><br> <label
											class="control-label" for="acname4">선택된 카테고리</label>&nbsp; <input
											id="acname4" class="form-control" type="text"
											placeholder="선택된 카테고리 (readonly)" name="acname" readonly><br>
									</div>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<div class="url-footer">
								<input class="btn btn-default btn-next" type="button" value="다음"
									onclick="showUrlStep2Form()">
							</div>
							<div class="category_unshared-footer" style="display: none">
								<input class="btn btn-default btn-prev" type="button" value="이전"
									onclick="showUrlForm()"> <input
									class="btn btn-default btn-comp" type="button" value="등록"
									onclick="addBookmarkButton()">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--urlAddModal end-->
	</section>
</div>
<!-- Main Content END -->
<!-- Color Picker JS START -->
<script src="/bit/js/admin/colorPick.js"></script>
<script>
        $(".colorPickSelector").colorPick({
            'initialColor': '#27ae60',
            'onColorSelected': function() {
                this.element.css({
                    'backgroundColor': this.color,
                    'color': this.color
                });
            }
        });
    </script>
<!-- Color Picker JS END -->

<!-- adminTable JS START -->
<script src="/bit/js/admin/jquery.dataTables.min.js"></script>
<script src="/bit/js/admin/dataTables.bootstrap.min.js"></script>
<!-- adminTable JS END -->

