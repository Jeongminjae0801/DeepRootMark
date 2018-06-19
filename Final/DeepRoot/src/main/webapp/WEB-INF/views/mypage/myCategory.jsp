<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <div id="content">
        <div class="container">
            <div class="row" style="padding-top: 150px;"></div>
            <div class="row my-row-bg">
                <!-- 카테고리 div -->
                <div class="col-lg-4 mydiv-height my-bookmark-div">
                    <!-- 마이 북마크 Heading -->
                    <div class="heading my-bookmark-list">
                      <i class="material-icons md-36">playlist_add_check</i><span class="mypage-title">마이 북마크</span>
                    </div>
                    <div style="color: orangered; background: white;width:120px;border: 1px solid orangered; border-radius: 6px 6px 6px 6px;  text-align: center;">new category</div>
                    <div style="background-color: white; border-radius: 15px 15px 15px 15px">
                        <div id="jstree_container"></div>
                    </div>

                </div>

                <!-- 선택한 폴더(카테고리)의 URL -->
                <div class="col-lg-5 mydiv-height my-bookmark-print-div">
                    <!-- 출력 Div Heading -->
                    <div class="heading my-bookmark-print-list">
                      <i class="material-icons md-36">playlist_add_check</i><span class="mypage-title">마이 북마크</span>
                    </div>
                    <button id="testing">url add</button>
                    <div style="background-color: white; border-radius: 15px 15px 15px 15px">
                        <div id="jstree_container_child"></div>
                    </div>

                </div>

                <!-- 내가 참여하는 그룹 리스트 -->
                <div class="col-lg-3 mydiv-height">
                    <!-- 참여중인 그룹리스트 -->
                    <div class="group-list-div panel group-list-panel">
                        <div class="heading group-list">
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
                        <div class="heading group-completed-list">
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
 <i class="jstree-icon jstree-themeicon jstree-themeicon-custom" role="presentation" style="background-image: url(&quot;https://www.google.com/s2/favicons?domain=https://colorscripter.com/&quot;); background-position: center center; background-size: auto;"></i>
