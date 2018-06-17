<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="app">
	<div class="wrapper">

		<header class="main-header">
			<span class="logo-mini"><a href="main.html"
				data-duration="0.2s"><span
					class="img-responsive center-block logo">뿌리깊은마크</span></a> </span>
			<!-- header menu bar START -->
			<nav role="navigation" class="navbar navbar-static-top">
				<a href="javascript:;" data-toggle="offcanvas" role="button"
					class="sidebar-toggle"><span class="sr-only">Toggle
						navigation</span></a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown messages-menu"><a href="javascript:;"
							data-toggle="dropdown" class="dropdown-toggle"><i
								class="fa fa-envelope-o"></i> <span class="label label-success">3</span></a>
							<!-- Message Alarm START -->
							<ul class="dropdown-menu">
								<li class="header">You have 1 message(s)</li>
								<li>
									<ul class="menu">
										<li><a href="javascript:;">
												<h4>
													Support Team <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4>
												<p>Why not consider this a test message?</p>
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="javascript:;">See All
										Messages</a></li>
							</ul> <!-- Message Alarm END --></li>
						<!-- Notice Alarm START -->
						<li class="dropdown notifications-menu"><a
							href="javascript:;" data-toggle="dropdown"
							class="dropdown-toggle"><i class="fa fa-bell-o"></i> <span
								class="label label-warning">0</span></a>
							<ul class="dropdown-menu">
								<li class="header">You have 0 notification(s)</li>
							</ul></li>
						<!-- Notice Alarm END -->

						<!-- Admin Infomation START -->
						<li class="dropdown user user-menu"><a href="javascript:;"
							data-toggle="dropdown" class="dropdown-toggle"><img
								src="https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg"
								alt="User Image" class="user-image"> <span
								class="hidden-xs">관리자(Admin)</span></a></li>
						<!-- Admin Infomation END -->
					</ul>
				</div>
			</nav>
			<!-- header menu bar END -->
		</header>

		<!-- SideMenu START -->
		<aside class="main-sidebar">
			<section class="sidebar">
				<ul class="sidebar-menu">
					<!-- Sidemenu Chart START -->
					<li class="header"><i class="fa fa-area-chart"></i>&nbsp;&nbsp;CHART</li>
					<li class="pageLink router-link-active"><a href="main.do"
						class="transition">&nbsp;&nbsp;&nbsp;<i
							class="fa fa-line-chart"></i> <span class="page">Chart</span></a></li>
					<!-- Sidemenu Chart END -->

					<!-- Sidemenu Pages Bookmark list START -->
					<li class="header"><i class="fa fa-book"></i>&nbsp;&nbsp;Bookmark
						List</li>
					<li class="pageLink"><a href="mainBookList.do">&nbsp;&nbsp;&nbsp;<i
							class="fa fa-bookmark fa-fw"></i><span class="page">Main
								Page Bookmark</span></a></li>
					<li class="pageLink"><a href="#">&nbsp;&nbsp;&nbsp;<i
							class="fa fa-bookmark fa-fw"></i><span class="page">Social
								Page Bookmark</span></a></li>
					<!-- Sidemenu Pages Bookmark list END -->

					<!-- Sidemenu List START -->
					<li class="header"><i class="fa fa-list-alt"></i>&nbsp;&nbsp;List</li>
					<li class="pageLink"><a href="groupListTable.do">&nbsp;&nbsp;&nbsp;<i
							class="fa fa-list-ul"></i><span class="page">Group List</span></a></li>
					<li class="pageLink"><a href="userListTable.do">&nbsp;&nbsp;&nbsp;<i
							class="fa fa-list-ul"></i><span class="page">User List</span></a></li>
					<!-- Sidemenu List END -->
				</ul>
			</section>
		</aside>
		<!-- Sidemenu END -->