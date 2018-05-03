<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <div class="container text-center">
  <h2>회원가입입니다.</h2>
  <hr/>
  <form class="form-horizontal">
    <div class="form-group">
      <label class="control-label col-sm-offset-2 col-sm-2" for="email">Email :</label>
      <div class="col-sm-4">
        <input type="email" class="form-control" id="email" placeholder="Enter email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-offset-2 col-sm-2" for="pwd">Password :</label>
      <div class="col-sm-4">
        <input type="password" class="form-control" id="pwd" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-offset-2 col-sm-2" for="name">Name :</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="name" placeholder="Name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-offset-2 col-sm-2" for="phone">Phone :</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="phone" placeholder="0101112222">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-7 col-sm-4">
        <button type="submit" class="btn btn-default">회원가입</button>
      </div>
    </div>
  </form>
</div>