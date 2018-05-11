<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>

<!-- Headers Start -->
<div id="header">
  <!-- Light header -->
  <header id="header-style-1">
    <nav class="navbar navbar-toggleable-sm navbar-light bg-faded">
      <div class="container" style="margin-left:0;margin-right:0px; width:100%;">
        <a class="navbar-brand" href="home.do"><img src="img/logo.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarCollapse">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="login.do">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Item 1</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown Item</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
</div>
<!-- Headers End -->