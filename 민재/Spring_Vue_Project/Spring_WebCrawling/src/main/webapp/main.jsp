<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" >
	$(function(){
		// hover 이미지 생성
		$("a").on("mouseover", function(){
			
			console.log($(this).attr("href"));
			
			$.ajax({
				url: "crawling.do",
				type: "post",
				data: {
					url:$(this).attr("href")
				},
				success: function(data){
					console.log(data.title);
					console.log(data.image);
					
					var html = "<div style='width:300px; height:300px; border: 1px solid black'>";
					
					html += "<img src='" + data.image + "' style='width:100%; height:60%'></img>";
					html += data.title + "<br>";
					html += data.description;
					html += "</div>";
					$("#img").html(html);
				}
			});
		});
		// hover out 이미지 사라짐
		$("a").on("mouseout", function(){
			$("#img").empty();
		});
		
		
	});


</script>

</head>
<body>
	<div id="website">
		<a href="https://www.naver.com">네이버</a>
		<a href="http://www.daum.net">다음</a>
		<a href="https://codepen.io">코드 펜</a>
		<a href="http://portal.changwon.ac.kr/portalMain/main.do?homecd=portal">창원대</a>
	</div>
	<hr>
	<div id="img">
	</div>
	
</body>
</html>