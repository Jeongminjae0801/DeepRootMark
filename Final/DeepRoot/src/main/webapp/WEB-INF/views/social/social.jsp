<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="ranking-div">
	<div class="container">
		<div class="row">
			<!-- Individual TOP5 DIV START -->
			<div class="col-sm-5">
				<div class="panel-body rank-table">
					<span class="ranktitle"><img src="../icon/trophy.png"
						class="rankimg">개인 Top 5</span>
					<table>
						<thead>
							<tr>
								<th>Rank</th>
								<th>사이트명</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<!-- 개인 북마크 공유 순위 -->
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
							<!-- 개인 북마크 공유 순위 -->
						</tbody>
					</table>
				</div>
			</div>
			<!-- Individual TOP5 DIV END -->
			<div class="col-sm-2 bg"></div>

			<!-- Group TOP5 DIV START -->
			<div class="col-sm-5">
				<div class="panel-body rank-table">
					<span class="ranktitle"><img src="../icon/trophy.png"
						class="rankimg">그룹 Top 5</span>
					<table>
						<thead>
							<tr>
								<th>Rank</th>
								<th>그룹명</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="rank"><img class="rankimg"
									src="../icon/gold.png">1</td>
								<td class="team">네이버</td>
								<td></td>
							</tr>
							<tr>
								<td class="rank"><img class="rankimg"
									src="../icon/silver.png">2</td>
								<td class="team">구글</td>
								<td></td>
							</tr>
							<tr>
								<td class="rank"><img class="rankimg"
									src="../icon/bronze.png">3</td>
								<td class="team">w3school</td>
								<td></td>
							</tr>
							<tr>
								<td class="rank"><img class="rankimg"
									src="../icon/medal2.png">4</td>
								<td class="team">Brazil</td>
								<td></td>
							</tr>
							<tr>
								<td class="rank"><img class="rankimg"
									src="../icon/medal2.png">5</td>
								<td class="team">Colombia</td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
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
			<div class="col-sm-6">
				<div class="panel-body">
					<span class="share-head"><img src="../icon/hash.png"
						class="shareimg">개인 북마크 공유</span>
					<table class="table table-hover" id="listTable1">
						<thead>
							<tr>
								<th>사이트명</th>
								<th class="table-tag">태그</th>
								<th>작성자</th>
								<th class="table-date">공유날짜</th>
								<th class="table-click">조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr class="index1">
								<td><a href="http://www.naver.com" target="_blank">네이버</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td><a data-toggle="modal" data-target="#myModal">작성자0</a>
								</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1130</td>
							</tr>
							<tr class="index3">
								<td><a href="http://www.daum.net" target="_blank">다음</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자1</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">900</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.google.com" target="_blank">구글</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자2</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.kakao.com" target="_blank">카카오</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자3</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.zum.com" target="_blank">ZUM</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자4</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index1">
								<td><a href="http://www.naver.com" target="_blank">네이버</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자0</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index3">
								<td><a href="http://www.daum.net" target="_blank">다음</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자1</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.google.com" target="_blank">구글</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자2</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.kakao.com" target="_blank">카카오</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자3</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.zum.com" target="_blank">ZUM</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자4</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index1">
								<td><a href="http://www.naver.com" target="_blank">네이버</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자0</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index3">
								<td><a href="http://www.daum.net" target="_blank">다음</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자1</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.google.com" target="_blank">구글</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자2</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.kakao.com" target="_blank">뿌리깊은마크</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자3</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.zum.com" target="_blank">ZUM</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자4</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- Individual Share Bookmark START -->

			<!-- Group Share Bookmark START -->
			<div class="col-sm-6">
				<div class="panel-body">
					<span class="share-head"><img src="../icon/hash.png"
						class="shareimg">그룹 북마크 공유</span>
					<table class="table table-hover" id="listTable2">
						<thead>
							<tr>
								<th>그룹명</th>
								<th class="table-tag">태그</th>
								<th>그룹장</th>
								<th class="table-date">공유날짜</th>
								<th class="table-click">조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr class="index1">
								<td><a href="http://www.naver.com" target="_blank">희준이와
										아이들</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자0</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index3">
								<td><a href="http://www.daum.net" target="_blank">다음</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자1</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.google.com" target="_blank">구글</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자2</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.kakao.com" target="_blank">카카오</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자3</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.zum.com" target="_blank">ZUM</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자4</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index1">
								<td><a href="http://www.naver.com" target="_blank">네이버</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자0</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index3">
								<td><a href="http://www.daum.net" target="_blank">다음</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자1</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.google.com" target="_blank">구글</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자2</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.kakao.com" target="_blank">카카오</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자3</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.zum.com" target="_blank">ZUM</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자4</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index1">
								<td><a href="http://www.naver.com" target="_blank">네이버</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자0</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index3">
								<td><a href="http://www.daum.net" target="_blank">다음</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자1</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.google.com" target="_blank">구글</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자2</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.kakao.com" target="_blank">카카오</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자3</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
							<tr class="index2">
								<td><a href="http://www.zum.com" target="_blank">ZUM</a></td>
								<td class="table-tag">#포털사이트 #검색</td>
								<td>작성자4</td>
								<td class="table-date">2018-06-12</td>
								<td class="table-click">1033</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- Group Share Bookmark END -->
		</div>
	</div>
</section>