<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">
/*  
 var _param = {
			firstname : $("#firstName").val(),
			lastname : $("#lastName").val(),
			email : $("#email").val()
		};
		_data = JSON.stringify(_param); //jsonString으로 변환
		alert(_data);
		$.ajax({
			type : 'POST',
			url : "response2.kosta",
			cache : false,
			dataType : "json",
			data : _data,
			processData : false,
			contentType : "application/json; charset=utf-8",
			success : function(data, status) {
				console.log("status:" + status + "," + "data:" + data);
				alert(data.email);
			},
			error : function(request, status, error) {
				//alert("loading error:" + request.status);
				console.log("code : " + request.statusText + "\r\nmessage : "
						+ request.responseText);
			}
		}); 
 */
	function madeAjaxCall(){
		
		$.ajax({
			type : 'POST',
			url : "idcheck.htm",
			dataType : "json",
			data : data,
			success : function(data){
					conslelog(data);
					if(data.trim() == "1"){
						alert("아이디가 존재합니다");	
					}
					else{
						alert("사용 가능한 아이디 입니다");
					}
			}
		});
	}

</script>
		
<div id="content">
	<form action="" method="post">
		<h2>회원가입</h2>
		<h3 class="hidden">방문페이지 로그</h3>
		<p id="breadscrumb" class="block_hlist clear">
			<img alt="Step1 개인정보 등록" src="images/step2.png" />
		</p>
		<h3 class="hidden">회원가입 폼</h3>
		<div id="join-form" class="join-form margin-large">
			<dl class="join-form-row">
				<dt class="join-form-title">아이디</dt>
				<dd class="join-form-data">
					<input type="text" name="userid" id="userid" /> <input id="btnCheckUid"
						class="button" type="button" value="중복확인" onclick="madeAjaxCall()" />
				</dd>
				
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">비밀번호</dt>
				<dd class="join-form-data">
					<input type="password" name="pwd" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">비밀번호 확인</dt>
				<dd class="join-form-data">
					<input type="password" name="pwd2" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">이름</dt>
				<dd class="join-form-data">
					<input type="text" name="name" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">성별</dt>
				<dd class="join-form-data">
					<select name="gender">
						<option>남성</option>
						<option>여성</option>
					</select>
				</dd>
			</dl>
			<dl class="join-form-row birthday">
				<dt class="join-form-title">생년월일</dt>
				<dd class="join-form-data">
					<span> <input type="text" id="year" />년 <input type="text"
						id="month" />월 <input type="text" id="day" />일 <input
						type="hidden" name="Birth" id="Birth" />
					</span> <span class="moon"> <input type="radio" name="IsLunar"
						value="Solar" id="IsSolar" checked />양력 <input type="radio"
						name="IsLunar" value="Lunar" id="IsLunar" />음력
					</span>
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">핸드폰 번호</dt>
				<dd class="join-form-data">
					<input type="text" name="cPhone" /><span>[대시(-)를 포함할 것: 예)
						010-3456-2934]</span>
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">이메일</dt>
				<dd class="join-form-data">
					<input type="text" name="email" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">취미</dt>
				<dd class="join-form-data habit">
					<input type="checkbox" name="habit" id="music" /><label
						for="music">음악</label> <input type="checkbox" name="habit"
						id="movie" /><label for="movie">영화</label> <input type="checkbox"
						name="habit" id="trip" /><label for="trip">여행</label>
				</dd>
			</dl>
		</div>
		<div id="buttonLine">
			<input class="btn-okay button" type="submit" value="가입" />
		</div>
	</form>

</div>
