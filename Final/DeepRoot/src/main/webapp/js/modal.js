
jQuery(function($) {
	$(function() {
		// 링크 내 북마크로 가져가기 버튼 클릭
		$('.url_hover_btn').on('dblclick', function(){});
	    $('.url_hover_btn').on('click', function(){
	    	// 모달 초기화 START
	    	$('#dropdownMenuButton').html("Click <span class='caret'></span>");
	    	$('#jstree-to-bottom').html('');
	    	$('#dropdown-empty-area').remove();	// 모달 초기화 END
	    	var url = $(this).parent().children('p').data('url');
	    	$('.indishare-url').val(url);
	    	$('.indishare-urlname').val($(this).parent().children('p').text());
	    	$('.indishare-abid').val( $(this).parent().children('p').data('abid'));
	    	
	    	// 진행중인 팀 리스트 가져오기
	    	$.ajax({
				url: "team/getTeamList.do",
			    type: "post",
			    success : function(data){
			    	var html = '<ul class="dropdown-menu">';
			    	
			    	var index = 0;
			    	for(var key in data.teamlist){
			    		if(index == 0){
			    			html += '<li class="dropdown-group-item" onclick="seletedGroup(' 
			    					+ "'" + data.teamlist[key].gname + "'" + ');"><span tabindex="-1">'
			    					+ data.teamlist[key].gname + '</span></li><hr class="divider-hr">';
			    		}else {
			    			html += '<li class="dropdown-group-item"><span>'+ data.teamlist[key].gname + '</span></li><hr class="divider-hr">';
			    		}
			    		index += 1;
			    	}
			    	html += '</ul>';
			    	$(".dropdown-item").append(html);
			    }
			});
	    });
	    
	    // 나의 북마크 선택했을 때, 
	    $('#dropdown-my-book').on('dblclick', function(){});
	    $('#dropdown-my-book').on('click', function(){
	    	$('#dropdownMenuButton').text($(this).text());
	    	$('#jstree-to-bottom').remove();
	    	$('.completed-modal-left:eq(1)').append('<div id="jstree-to-bottom" style="clear: both;"></div>');

	    	$.ajax({
				url : "user/getCategoryList.do",
				type:"POST",
				dataType:"json",
				success : function(data){
					/*jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다.*/	
					$("#jstree-to-bottom").on("click",'.jstree-anchor',function(e){// 한번만 클릭해서 폴더 열기
						$('#jstree-to-bottom').jstree(true).toggle_node(e.target);
					}).jstree({	
							"core": {
								"dblclick_toggle" : false, 	// 두번 클릭해서 폴더여는거 false
								'data' : data, 				//ajax로 가져온 json data jstree에 넣어주기
								'themes':{
									'name' : 'proton', 		//테마 이름
									'responsive' : true,
									"dots": false, 			// 연결선 없애기
								}
							}
					}).bind("select_node.jstree", function (e, data) {
						/*노드(폴더)가 선택시 실행되는 함수*/					
	 					var id = data.node.id;
	 					$('.indishare-userpid').val(id);
	 					
					});
				}
			});
	    });
	    
	    $('#into-my-bookmark').on('dblclick', function(){});
	    $('#into-my-bookmark').on('click', function(){
	    	var params = $("#form-to-mybookmark").serialize();
    		$.ajax({
				url : "user/addtomybookmark.do",
				type:"POST",
				data: params,
				dataType:"json",
				success : function(data){
					if(data.result == "success") {
						$.alert("MYBOOKMARK에 추가 되었습니다.");
						$('#mainIndiModal').modal("toggle");
					}else {
						$.alert("잠시후 다시 시도해주세요.");
						$('#mainIndiModal').modal("toggle");
					}
				}
			});
	    	
	    });
	});
});

// 내의 그룹리스트 중 하나를 선택 했을 때,
function seletedGroup(group) {
	$('#dropdownMenuButton').text(group);
}



