<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form action="#" id="login-form">
  <div class="login-left">
    <label for="email">Email</label> <br>
    <input type="email" name="email" id="login-email"> <br>
    <label for="password">Password</label> <br>
    <input type="password" name="password" id="login-pass"> <br>
    <input type="submit" value="Login" />
  </div>
  
  <div class="login-right">
    <div class="connect">Connect with</div>
    <a href="" class="facebook">
      <i class="fa fa-facebook" aria-hidden="true"></i>
    </a> <br />
    
    <a href="" class="google-plus">
      <i class="fa fa-google-plus" aria-hidden="true"></i>
    </a>
  </div>
</form>
