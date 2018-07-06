<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content"  class="container">
	<div class="panel panel-success">
		<div class="panel-heading" style="text-align: center"><b>마이페이지</b></div>
			<div class="panel-body">
				<form method="post">
					<table class="table">
						<tr>
							<td>
								<div class="input-group">
									  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			     			 	      <input id="userid" type="text" class="form-control" name="userid" value="${member.userid}" readonly>
								</div>
							</td>
						</tr>
						<tr>
	  						<td>
	  							<div class="input-group">
		  							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
		  							<input id="pwd" type="password"  value="" class="form-control" name="pwd" placeholder="새 비밀번호 입력">
	  							</div>
	  						</td>
	  					</tr>
						<tr>
							<td>
								<div class="input-group">
									  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			     			 	      <input id="name" type="text" class="form-control" name="name" value="${member.name}" readonly>
								</div>
							</td>
						</tr>
						<tr>
	  						<td>
	  							<div class="input-group">
		  							<span class="input-group-addon"><i class="	glyphicon glyphicon-heart"></i></span>
		  							<input id="gender" type="text" class="form-control" name="gender"  value="${member.gender}"  readonly>
	  							</div>
	  						</td>
	  					</tr>
	  					<tr>
	  						<td>
	  							<div class="input-group">
		  							<span class="input-group-addon"><i class="	glyphicon glyphicon-phone"></i></span>
		  							<input id="cPhone" type="text" class="form-control" name="cPhone"  value="${member.cPhone}"  >
	  							</div>
	  						</td>
	  					</tr>
	  					<tr>
	  						<td>
	  							<div class="input-group">
		  							<span class="input-group-addon"><i class="	glyphicon glyphicon-envelope"></i></span>
		  							<input id="email" type="text" class="form-control" name="email"  value="${member.email}"  >
	  							</div>
	  						</td>
	  					</tr>
	  					<table class="table">
	  						<colgroup>
								<col width="70%">
								<col width="30%">							
							</colgroup>
							<tr>
								<td></td>
								<td><input type="submit" class="btn btn-success btn-sm" value="수정하기"></td>
							</tr>
							</table>	
	  					</table>
					
					
						<%-- <tr>
							
							<th>아이디</th>
							<th>비밀번호</th>
							<th>이름</th>
							<th>성별</th>
							<th>전화번호</th>
							<th>email</th>
						</tr>
						<tr>
							<td><input type="text" value="${member.userid}" name="userid" readonly></td>
							<td><input type="password" value="" name="pwd"></td>
							<td><input type="text" value="${member.name}" name="name"></td>
							<td><input type="text" value="${member.gender}" name="gender" readonly></td>
							<td><input type="text" value="${member.cPhone}" name="cPhone"></td>
							<td><input type="text" value="${member.email}" name="email"></td>
						</tr>
						<tr>
							<td colspan="5"><input type="submit" value="수정"></td>
						</tr> --%>
		
			</form>
		</div>
	</div>
</div>


