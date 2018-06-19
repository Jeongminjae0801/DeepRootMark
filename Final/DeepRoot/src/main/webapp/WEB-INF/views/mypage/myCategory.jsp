<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div id="content">
        <img class="bg-img bg-right-top" src="${pageContext.request.contextPath}/images/mypage/bookshelf.jpg" alt="">
        <img class="bg-img bg-left-bottom" src="${pageContext.request.contextPath}/images/mypage/hill.png" alt="">
        <div class="container">
            <div class="row" style="padding-top: 150px;"></div>
            <div class="row my-row-bg">
                <!-- 카테고리 div -->
                <div class="col-lg-4 mydiv-height my-bookmark-div">
                    <img src="${pageContext.request.contextPath}/images/mypage/left_spring.png" alt="" class="spring left-top">
                    <img src="${pageContext.request.contextPath}/images/mypage/left_spring.png" alt="" class="spring left-bottom">
                    <!-- 마이 북마크 Heading -->
                    <div class="heading my-bookmark-list">
                      <i class="material-icons md-32">archive</i><span class="mypage-title">마이 북마크</span>
                      <button type="button" class="my-boomark-btn">New Category</button>
                    </div>
                    <div style="background-color: white; border-radius: 15px 15px 15px 15px">
                        <div id="jstree_container"></div>
                    </div>
                </div>

                <!-- 선택한 폴더(카테고리)의 URL -->
                <div class="col-lg-4 mydiv-height my-bookmark-print-div">
                    <img src="${pageContext.request.contextPath}/images/mypage/right_spring.png" alt="" class="spring right-top">
                    <img src="${pageContext.request.contextPath}/images/mypage/right_spring.png" alt="" class="spring right-bottom">
                    <!-- 출력 Div Heading -->
                    <div class="heading my-bookmark-print-list ">
                      <i class="material-icons md-32 pull-left">view_list</i><span class="mypage-title pull-left">리스트</span>
                      <span class="mypage-title">&nbsp;</span>
                      <button type="button" class="my-boomark-btn">Add URL</button>
                    </div>
                    <div>
                        <div id="jstree_container_child"></div>
                    </div>

                </div>

                <!-- 내가 참여하는 그룹 리스트 -->
                <div class="col-lg-3 mydiv-height">
                    <!-- 참여중인 그룹리스트 -->
                    <div class="group-list-div panel group-list-panel">
                        <div class="heading-post-top group-list">
                          <i class="material-icons md-36">playlist_play</i><span class="mypage-title">그룹리스트</span>
                        </div>
                        <div class="panel-body">
                            <ul class="group-list-list">
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <!-- 완료된 그룹리스트 -->
                    <div class="completed-group-list-div panel group-completed-list-panel">
                        <div class="heading-post-bottom group-completed-list">
                          <i class="material-icons md-36">playlist_add_check</i><span class="mypage-title">완료된 그룹</span>
                        </div>
                        <div class="panel-body-scroll">
                            <ul class="group-list-list">
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <label class="my-group-list">
                                        List group item heading 1
                                    </label>
                                    <div class="pull-right action-buttons">
                                        <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
 