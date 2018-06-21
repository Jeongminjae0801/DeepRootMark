<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- 소셜 페이지 완료 그룹 가져오기 Modal -->
<div id="socialGroupModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="socialGroupModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="gridSystemModalLabel">Title</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-9">
						Level 1: .col-sm-9
						<div class="row">
							<div class="col-xs-8 col-sm-6">Level 2: .col-xs-8 .col-sm-6
							</div>
							<div class="col-xs-4 col-sm-6">Level 2: .col-xs-4 .col-sm-6
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- social 개인 북마크 가져가기 div START -->
<div id="socialindiModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="socialGroupModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="gridSystemModalLabel">북마크 가져가기</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-9">
					
						url : <input type="text" value="ㅇㅇㅇㅇ">
						<div class="row">
							<div class="col-xs-8 col-sm-6">Level 2: .col-xs-8 .col-sm-6
							</div>
							<div class="col-xs-4 col-sm-6">Level 2: .col-xs-4 .col-sm-6
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>
<!-- social 개인 북마크 가져가기 div END -->

<section class="ranking-div">
	<div class="container">
		<div class="row">
			<!-- Individual TOP5 DIV START -->
			<!-- top5 list start -->
			<div class="col-sm-5">
				<div class="panel-body rank-table">
					<span class="ranktitle"><img src="../icon/trophy.png"
						class="rankimg">개인 Top 5</span>
					<table>
						<thead>
							<tr>
								<th>Rank</th>
								<th>사이트명</th>
								<th>공유개수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${u_top5}" var="user_top" varStatus="status">
								<tr>
									<c:choose>
										<c:when test="${status.count == '1'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/gold.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '2'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/silver.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '3'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/bronze.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '4'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/medal2.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '5'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/medal2.png">${status.count}</td>
										</c:when>
									</c:choose>
									<td><a href="${user_top.url}" target="_blank">${user_top.urlname}</a></td>
									<td>${user_top.ucount}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- top5 list end -->
			<!-- Individual TOP5 DIV END -->
			<div class="col-sm-2"></div>

			<!-- Group TOP5 DIV START -->
			<!-- Gtop5 list start -->
			<div class="col-sm-5">
				<div class="panel-body rank-table">
					<span class="ranktitle"><img src="../icon/trophy.png"
						class="rankimg">그룹 Top 5</span>
					<table>
						<thead>
							<tr>
								<th>Rank</th>
								<th>사이트명</th>
								<th>공유개수</th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach items="${g_top5}" var="group_top" varStatus="status">
								<tr>
									<c:choose>
										<c:when test="${status.count == '1'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/gold.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '2'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/silver.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '3'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/bronze.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '4'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/medal2.png">${status.count}</td>
										</c:when>
										<c:when test="${status.count == '5'}">
											<td class="rank"><img class="rankimg"
												src="<%=request.getContextPath()%>/icon/medal2.png">${status.count}</td>
										</c:when>
									</c:choose>
									<td><a href="${group_top.url}" target="_blank">${group_top.urlname}</a></td>
									<td>${group_top.ucount}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- Gtop5 list end -->
		</div>
		<!-- Group TOP5 DIV END -->
	</div>
</section>
<!-- Top5 DIV END -->
<section class="slideimg"></section>

<!-- Share Bookmark div START -->
<section class="bookmark-share-div">
	<img src="../images/social/books.png" class="bg-bottom">
	<div class="container">
		<div class="row">
			<!-- Individual Share Bookmark START -->
			<!-- u_booklist start -->
			<div class="col-sm-6">
				<div class="panel-body">
					<span class="share-head"><img src="../icon/hash.png"
						class="shareimg">개인 북마크 공유</span>
					<table class="table table-hover" id="listTable1">
						<thead>
							<tr>
								<th class="table-site">사이트명</th>
								<th class="table-tag">태그</th>
								<th class="table-write">작성자</th>
								<th class="table-date">공유날짜</th>
								<th class="table-click">조회수</th>
								<th class="table-icon"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${u_list}" var="u_booklist">
							<!-- 개인 북마크 공유 -->
								<tr>
									<td class="table-site"><a href="${u_booklist.url}" target="_blank">${u_booklist.sname}</a></td>
									<td class="table-tag">"${u_booklist.htag}"</td>
									<td class="table-write"><a>${u_booklist.nname}</a></td>
									<td class="table-date">${u_booklist.sdate}</td>
									<td class="table-click">${u_booklist.view}</td>
									<td class="table-icon indi-share" data-toggle="modal" data-target="#socialindiModal"><i class="fa fa-share"></i></td>
								</tr>
							</c:forEach>
							<!-- 개인 북마크 공유 -->
						</tbody>
					</table>
				</div>
			</div>
			<!-- u_booklist end -->
			<!-- Individual Share Bookmark START -->

			<!-- Group Share Bookmark START -->
			<div class="col-sm-6">
				<div class="panel-body">
					<span class="share-head"><img src="../icon/hash.png"
						class="shareimg">그룹 북마크 공유</span>
					<table class="table table-hover" id="listTable2">
						<thead>
							<tr>
								<th class="table-groupname">그룹명</th>
								<th class="table-tag">태그</th>
								<th class="table-write">그룹장</th>
								<th class="table-date">공유날짜</th>
								<th class="table-click">조회수</th>
								<th class="table-icon"></th>
							</tr>
						</thead>
						<!-- g_list start -->
						<tbody>
							<!-- 그룹 공유   -->
							<c:forEach items="${g_list}" var="g_booklist">
								<tr>
								<!-- 그룹 공유  -->
									<td class="table-groupname"><a href="" target="_blank">${g_booklist.gname}</a></td>
									<td class="table-tag">"${g_booklist.htag}"</td>
									<td class="table-write">${g_booklist.nname}</td>
									<td class="table-date">${g_booklist.duedate}</td>
									<td class="table-click"></td>
									<!-- 가져오기 icon -->
									<td class="table-icon" data-toggle="modal" data-target="#socialGroupModal"><i class="fa fa-share"></i></td>
									<!-- 가져오기 icon -->
								</tr>
							</c:forEach>
							<!-- 그룹 공유   -->
						</tbody>
						<!-- g_list end -->
					</table>
				</div>
			</div>
			<!-- Group Share Bookmark END -->
		</div>
	</div>
</section>

