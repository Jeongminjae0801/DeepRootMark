$.fn.serializeObject = function(){
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	    	var name = $.trim(this.name),
	    		value = $.trim(this.value);
	    	
	        if (o[name]) {
	            if (!o[name].push) {
	                o[name] = [o[name]];
	            }
	            o[name].push(value || '');
	        } else {
	            o[name] = value || '';
	        }
	    });
	    return o;
	};

jQuery(function($) {
	'use strict';
	var first_data = null;

	// Responsive Nav
	$('li.dropdown').find('.fa-angle-down').each(function() {
		$(this).on('click', function() {
			if ($(window).width() < 768) {
				$(this).parent().next().slideToggle();
			}
			return false;
		});
	});

	// Fit Vids
	if ($('#video-container').length) {
		$("#video-container").fitVids();
	}

	// Initiat WOW JS
	new WOW().init();




	function count(options) {
		var $this = $(this);
		options = $.extend({}, options || {}, $this.data('countToOptions') || {});
		$this.countTo(options);
	}

	// Search
	$('.fa-search').on('click', function() {
		$('.field-toggle').fadeToggle(200);
	});

	// Contact form
	var form = $('#main-contact-form');
	form.submit(function(event) {
		event.preventDefault();
		var form_status = $('<div class="form_status"></div>');
		$.ajax({
			url: $(this).attr('action'),
			beforeSend: function() {
				form.prepend(form_status.html('<p><i class="fa fa-spinner fa-spin"></i> Email is sending...</p>').fadeIn());
			}
		}).done(function(data) {
			form_status.html('<p class="text-success">Thank you for contact us. As early as possible  we will contact you</p>').delay(3000).fadeOut();
		});
	});

	// Progress Bar
	$.each($('div.progress-bar'), function() {
		$(this).css('width', $(this).attr('data-transition') + '%');
	});

	if ($('#gmap').length) {
		var map;

	    map = new GMaps({
			el : '#gmap',
			lat : 43.04446,
			lng : -76.130791,
			scrollwheel : false,
			zoom : 16,
			zoomControl : false,
			panControl : false,
			streetViewControl : false,
			mapTypeControl : false,
			overviewMapControl : false,
			clickable : false
	    });

	    map.addMarker({
			lat : 43.04446,
			lng : -76.130791,
			animation : google.maps.Animation.DROP,
			verticalAlign : 'bottom',
			horizontalAlign : 'center',
			backgroundColor : '#3e8bff',
		});
	}
	
	$(document).ready(function() {
		// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
		var floatPosition = parseInt($("#floatMenu").css('top'));
		// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );
	
		$(window).scroll(function() {
			// 현재 스크롤 위치를 가져온다.
			var scrollTop = $(window).scrollTop();
			var newPosition = scrollTop + floatPosition - 400 + "px";
			var fixedpositon = floatPosition + "px";
		
			// 애니메이션 없이 바로 따라감
			if ($(this).scrollTop() <= 400)
				scrollTop.toFixed();
			else
				$("#floatMenu").css('top', newPosition);
		
		}).scroll();
	});
});

/* 민재 onclick */
// 개인 북마크 목록 가져가기 START
$(function() {
	// 링크 내 북마크로 가져가기 버튼 클릭
	$('.getbookmark').on('dblclick', function(){});
    $('.getbookmark').on('click', function(){
    	$('#socialIndiModal').css({"z-index":"9999"});
    	// 모달 초기화 START
    	$('#dropdownMenuButton').html("Click <span class='caret'></span>");
    	$('#jstree-to-bottom').html('');
    	$('#dropdown-empty-area').remove();	
    	$('.indishare-urlname').val($(this).parent().parent().children().eq(0).children('a').text()); 
    	// 모달 초기화 END
    });
    
    // 나의 북마크 선택했을 때, 
    $('#dropdown-my-book').on('dblclick', function(){});
    $('#dropdown-my-book').on('click', function(){
    	// Modal init()
    	$('#dropdownMenuButton').text($(this).text());
    	$('#into-my-bookmark').css('display', 'block');
    	$('#into-group-bookmark').css('display', 'none');
    	$('#jstree-to-bottom').remove();
    	$('.completed-modal-left:eq(1)').append('<div id="jstree-to-bottom" style="clear: both;"></div>');
    	
    	$.ajax({
			url : "/bit/user/getCategoryList.do",
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
 
    // [확인]: 나의 북마크로 추가 버튼 클릭했을 때, 
    $('#into-my-bookmark').on('dblclick', function(){});
    $('#into-my-bookmark').on('click', function(){
    	
    	/*var params = $("#form-to-getmybookmark").serialize();*/
		$.ajax({
			url : "getmybookmark.do",
			type: "post",
			data: {
				"url": $(".indishare-url").val(),
				"urlname" : $(".indishare-urlname").val(),
				"pid": $(".indishare-userpid").val()
			},
			//dataType: "json",
			success : function(data){
				if(data.result == "success") {
					swal("Thank you!", "북마크에 추가되었습니다!", "success");
					$('#socialIndiModal').modal("toggle");
				}else {
                    swal({
                        title: "목적지 폴더를 확인하셨나요?",
                        text: "잠시후 다시 시도해주세요!",
                        icon: "warning",
                        buttons: true,
                        dangerMode: true
					});
				}
			},
			error : function(error) {
				swal({
                    title: "목적지 폴더를 확인하셨나요?",
                    text: "잠시후 다시 시도해주세요!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
				});
		    }
		});
    });
    
    // [확인]: 그룹 북마크로 추가 버튼 클릭했을 때, 
    $('#into-group-bookmark').on('dblclick', function(){});
    $('#into-group-bookmark').on('click', function(){
    	/*var params = $("#form-to-mybookmark").serialize();
    	console.log(params);*/
		$.ajax({
			url : "getGroupBook.do",
			type: "POST",
			data: {
				"url": $(".indishare-url").val(),
				"urlname" : $(".indishare-urlname").val(),
				"pid": $(".indishare-userpid").val(), 
				"gid": $(".indishare-gid").val()
			},
			dataType:"json",
			success : function(data){
				console.log(data.result);
				if(data.result == "success") {
					swal("Thank you!", "북마크에 추가되었습니다!", "success");
					$('#socialIndiModal').modal("toggle");
				}else {
                    swal({
                        title: "목적지 폴더를 확인하셨나요?",
                        text: "잠시후 다시 시도해주세요!",
                        icon: "warning",
                        buttons: true,
                        dangerMode: true
					});
				}
			},
			error : function(error) {
				swal({
                    title: "목적지 폴더를 확인하셨나요?",
                    text: "잠시후 다시 시도해주세요!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
				});
		    }
		});
    });
    $('#socialIndiModal').css({"z-index":"0"});
});

//내의 그룹리스트 중 하나를 선택 했을 때,
function selectedGroup(group, gid) {
	// Modal Init()
	$('#dropdownMenuButton').text(group);
	$('.indishare-gid').val(gid);
	$('#into-my-bookmark').css('display', 'none');
	$('#into-group-bookmark').css('display', 'block');
	$('#jstree-to-bottom').remove();
	$('.completed-modal-left:eq(1)').append('<div id="jstree-to-bottom" style="clear: both;"></div>');

	$.ajax({
		url : "/bit/team/getGroupCategoryList.do",
		type:"POST",
		data: {gid: gid},
		dataType:"json",
		success : function(data){
			// jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다.	
			$("#jstree-to-bottom").on("click",'.jstree-anchor',function(e){// 한번만 클릭해서 폴더 열기
				$('#jstree-to-bottom').jstree(true).toggle_node(e.target);
			}).jstree({	
					"core": {
						"dblclick_toggle" : false, 	// 두번 클릭해서 폴더여는거 false
						'data' : data.data, 		// ajax로 가져온 json data jstree에 넣어주기
						'themes':{
							'name' : 'proton', 		// 테마 이름
							'responsive' : true,
							"dots": false, 			// 연결선 없애기
						}
					}
			}).bind("select_node.jstree", function (e, data) {
			//노드(폴더)가 선택시 실행되는 함수
				var id = data.node.id;
				//console.log(id);//PID
				$('.indishare-userpid').val(id);
					
			});
		}
	});
}
//개인 북마크 목록 가져가기 END

//그룹 공유 북마크 가져가기 START
function get_groupbook(group){
	$('.nname').text(group.id);
	//클릭한 작성자 닉네임
	var nname = group.id;
	
	$.ajax({
		url : "getCategoryList.do",
		type : "POST",
		data : {nname : nname},
		dataType :"json",
		success : function(obj){
			first_data = obj;
			$('#jstree-from-left-group').jstree(true).settings.core.data = obj;
			$('#jstree-from-left-group').jstree(true).refresh();
		}
	})
	//모달열기
	$('#socialGroupModal').modal();
};

$(document).ready(function(){
	//파도타기 모달 왼쪽 jstree
    $("#jstree-from-left-group").jstree({
    	"core" : {
    		'data' : first_data,
    		'themes':{
    			'name' : 'proton',
    			'responsive' : true,
    			'dots' : false,
    		}
    	}
    
    }).bind("select_node.jstree",function(event,data){
	    var url = $('#jstree-from-left-group').jstree(true).get_node(data.node.id).a_attr.href;
	    $('.indishare-url-surfing').text(url);
        var urlname = $('#jstree-from-left-group').jstree(true).get_node(data.node.id).original.text;
        $('.groupshare-urlname-left').val(urlname);
    })
        
    //파도타기 모달 오른쪽 jstree
    //나의 북마크 선택했을 때
    $('#dropdown-my-bookmark').on('dblclick', function(){});
    $('#dropdown-my-bookmark').on('click', function(){
    	$('#dropdownMenuButton').text($(this).text());
    	$('#into-my-bookmark-btn').css('display', 'inline');
    	$('#into-group-bookmark-btn').css('display', 'none');
    	$('#jstree-to-right-all').remove();
    	$('.completed-modal-right-all').append('<div id="jstree-to-right-all"></div>');

    	$.ajax({
    		url : "../user/getCategoryList.do",
			type:"POST",
			dataType:"json",
			success : function(data){
				//jstree 시작, jstree를 뿌려주고 싶은 div의 id를 적어준다
				$("#jstree-to-right-all").jstree({
					"core": {
						'data' : data, 				//ajax로 가져온 json data jstree에 넣어주기
						'themes': {
							'name' : 'proton', 		//테마 이름
							'responsive' : true,
							"dots": false, 			//연결선 없애기
						}
					}
				
				//노드(폴더)가 선택시 실행되는 함수
				}).bind("select_node.jstree", function (e, data) {
	 				var id = data.node.id;
	 				$('.indishare-userpid-left').val(id);	
				});
			}
    	});	
    });
    
    // 링크 내 북마크로 가져가기 버튼 클릭
    $('.table-write').on('dblclick', function(){});
    $('.table-write').on('click', function(){
    	//모달 초기화 START
    	$('#dropdownMenuButton').html("Click <span class='caret'></span>");
    	$('#jstree-to-right-all').html('');
	    $('.indishare-url-surfing').text('');
	    $('.indishare-urlname-left').val('');
	    $('.indishare-abid-left').val('');
	    //모달 초기화 END
	    
	    //진행중인 팀 리스트 가져오기
	    $.ajax({
	    	url: "../team/getTeamList.do",
	    	type: "post",
	    	success : function(data){
	    		var html = '<ul class="dropdown-menu">';
			    var index = 0;
			    for(var key in data.teamlist){
			    	
			    	if (index == 0) {
			    		html += '<li class="dropdown-group-item" onclick="seletedGroup('
			    			+ "'" + data.teamlist[key].gname + "', '" + data.teamlist[key].gid
			    			+ "');" + '"><span tabindex="-1">' + data.teamlist[key].gname
			    			+ '</span></li><hr class="divider-hr">';
			    	} else {
			    		html += '<li class="dropdown-group-item" onclick="seletedGroup('
			    			+ "'" + data.teamlist[key].gname + "', '" + data.teamlist[key].gid
			    			+ "');" + '"><span>' + data.teamlist[key].gname
			    			+ '</span></li><hr class="divider-hr">';
			    	}
			    	index += 1;
			    }
			    html += '</ul>';
			    $(".dropdown-item").append(html);
	    	}
	    });
    });
    
    //[버튼]:나의 북마크로 추가 버튼 클릭했을 때
    $('#into-my-bookmark-btn').on('dblclick', function(){});
    $('#into-my-bookmark-btn').on('click', function(){
    	if($('.indishare-url-surfing').text() == '#'){
    		swal({
    			title: "목적지 폴더를 확인하셨나요?",
    			text: "잠시후 다시 시도해주세요!",
    			icon: "warning",
    			buttons: true,
    			dangerMode: true
    		});
    		return;
    	}
    	$.ajax({
    		url : "getmybookmark.do",
    		type:"POST",
    		data: {
    			url: $('.indishare-url-surfing').text(),
				urlname: $('.indishare-urlname-left').val(),
				pid: $('.indishare-userpid-left').val()
    		},
    		success : function(data){
    			if(data.result == "success") {
    				swal("Thank you!", "북마크에 추가되었습니다!", "success");
    				$('#socialSurfingModal').modal("toggle");
    			} else {
    				swal({
    					title: "목적지 폴더를 확인하셨나요?",
                        text: "잠시후 다시 시도해주세요!",
                        icon: "warning",
                        buttons: true,
                        dangerMode: true
    				});
    			}
    		},
    		error : function(error) {
    			swal({
    				title: "목적지 폴더를 확인하셨나요?",
                    text: "잠시후 다시 시도해주세요!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
    			});
    		}
		});
    });
    
    //[버튼]:그룹 북마크로 추가 버튼 클릭했을 때
    $('#into-group-bookmark-btn').on('dblclick', function(){});
	$('#into-group-bookmark-btn').on('click', function(){
		if($('.indishare-url-surfing').text() == '#'){
			swal({
				title: "목적지 폴더를 확인하셨나요?",
                text: "잠시후 다시 시도해주세요!",
                icon: "warning",
                buttons: true,
                dangerMode: true
			});
			return;
		}
		$.ajax({
			url : "getGroupBook.do",
			type: "POST",
			data: {
				url: $('.indishare-url-surfing').text(),
				urlname: $('.indishare-urlname-left').val(),
				pid: $('.indishare-userpid-left').val(), 
   				gid: $('.indishare-gid-left').val()
			},
			success : function(data){
				if(data.result == "success") {
					swal("Thank you!", "북마크에 추가되었습니다!", "success");
					$('#socialSurfingModal').modal("toggle");
				} else {
					swal({
						title: "목적지 폴더를 확인하셨나요?",
						text: "잠시후 다시 시도해주세요!",
	                    icon: "warning",
	                    buttons: true,
	                    dangerMode: true
					});
				}
			},
			error : function(error) {
				swal({
					title: "목적지 폴더를 확인하셨나요?",
                    text: "잠시후 다시 시도해주세요!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
				});
			}
		});
	});
})
    
//내 그룹리스트 중 하나를 선택 했을 때,
function seletedGroup(group, gid) {
	$('#dropdownMenuButton').text(group);
	$('.indishare-gid-left').val(gid);
	$('#into-my-bookmark-btn').css('display', 'none');
	$('#into-group-bookmark-btn').css('display', 'inline');
	$('#jstree-to-right-all').remove();
	$('.completed-modal-right-all').append('<div id="jstree-to-right-all"></div>');
	
	$.ajax({
		url : "../team/getGroupCategoryList.do",
		type:"POST",
		data: {gid: gid},
		dataType:"json",
		success : function(data){
			$("#jstree-to-right-all").jstree({
				"core": {
					'data' : data.data,
					'themes':{
						'name' : 'proton',
						'responsive' : true,
						"dots": false,
					}
				}
			
			}).bind("select_node.jstree", function (e, data) {
				var id = data.node.id;
				$('.indishare-userpid-left').val(id);
			});
		}
	});
}


/* 민재 onclick END */

/* 태웅이 onclick */

$('.indi-share').on('dblclick', function(){ return });
$('.indi-share').on('click', function(){
	var title = $(this).data('title');
	$('.indishare-url').val(title);
});


$('.group-share').on('dblclick', function(){ return });
$('.group-share').on('click', function(){
	var title = $(this).data('title');
	$('.groupshare-name').text(title);
});

/* 태웅이 onclick END */

/*진수 start*/
var first_data = null;

function surfing_modal(d){
	$('.nname').text(d.id);
	//클릭한 작성자 닉네임
	var nname = d.id;
	
	$.ajax({
		url : "getCategoryList.do",
		type : "POST",
		data : {nname : nname},
		dataType :"json",
		success : function(obj){
			first_data = obj;
			$('#jstree-from-left-all').jstree(true).settings.core.data = obj;
			$('#jstree-from-left-all').jstree(true).refresh();
		}
	})
	//모달열기
	$('#socialSurfingModal').modal();
};

$(document).ready(function(){
	//파도타기 모달 왼쪽 jstree
    $("#jstree-from-left-all").jstree({
    	"core" : {
    		'data' : first_data,
    		'themes':{
    			'name' : 'proton',
    			'responsive' : true,
    			'dots' : false,
    		}
    	}
    
    }).bind("select_node.jstree",function(event,data){
	    var url = $('#jstree-from-left-all').jstree(true).get_node(data.node.id).a_attr.href;
	    $('.indishare-url-surfing').text(url);
        var urlname = $('#jstree-from-left-all').jstree(true).get_node(data.node.id).original.text;
        $('.indishare-urlname-left').val(urlname);
    })
        
    //파도타기 모달 오른쪽 jstree
    //나의 북마크 선택했을 때
    $('#dropdown-my-bookmark').on('dblclick', function(){});
    $('#dropdown-my-bookmark').on('click', function(){
    	$('#dropdownMenuButton').text($(this).text());
    	$('#into-my-bookmark-btn').css('display', 'inline');
    	$('#into-group-bookmark-btn').css('display', 'none');
    	$('#jstree-to-right-all').remove();
    	$('.completed-modal-right-all').append('<div id="jstree-to-right-all"></div>');

    	$.ajax({
    		url : "../user/getCategoryList.do",
			type:"POST",
			dataType:"json",
			success : function(data){
				//jstree 시작, jstree를 뿌려주고 싶은 div의 id를 적어준다
				$("#jstree-to-right-all").jstree({
					"core": {
						'data' : data, 				//ajax로 가져온 json data jstree에 넣어주기
						'themes': {
							'name' : 'proton', 		//테마 이름
							'responsive' : true,
							"dots": false, 			//연결선 없애기
						}
					}
				
				//노드(폴더)가 선택시 실행되는 함수
				}).bind("select_node.jstree", function (e, data) {
	 				var id = data.node.id;
	 				$('.indishare-userpid-left').val(id);	
				});
			}
    	});	
    });
    
    // 링크 내 북마크로 가져가기 버튼 클릭
    $('.table-write').on('dblclick', function(){});
    $('.table-write').on('click', function(){
    	//모달 초기화 START
    	$('#dropdownMenuButton').html("Click <span class='caret'></span>");
    	$('#jstree-to-right-all').html('');
	    $('.indishare-url-surfing').text('');
	    $('.indishare-urlname-left').val('');
	    $('.indishare-abid-left').val('');
	    //모달 초기화 END
	    
	    //진행중인 팀 리스트 가져오기
	    $.ajax({
	    	url: "../team/getTeamList.do",
	    	type: "post",
	    	success : function(data){
	    		var html = '<ul class="dropdown-menu">';
			    var index = 0;
			    for(var key in data.teamlist){
			    	
			    	if (index == 0) {
			    		html += '<li class="dropdown-group-item" onclick="seletedGroup('
			    			+ "'" + data.teamlist[key].gname + "', '" + data.teamlist[key].gid
			    			+ "');" + '"><span tabindex="-1">' + data.teamlist[key].gname
			    			+ '</span></li><hr class="divider-hr">';
			    	} else {
			    		html += '<li class="dropdown-group-item" onclick="seletedGroup('
			    			+ "'" + data.teamlist[key].gname + "', '" + data.teamlist[key].gid
			    			+ "');" + '"><span>' + data.teamlist[key].gname
			    			+ '</span></li><hr class="divider-hr">';
			    	}
			    	index += 1;
			    }
			    html += '</ul>';
			    $(".dropdown-item").append(html);
	    	}
	    });
    });
    
    //[버튼]:나의 북마크로 추가 버튼 클릭했을 때
    $('#into-my-bookmark-btn').on('dblclick', function(){});
    $('#into-my-bookmark-btn').on('click', function(){
    	if($('.indishare-url-surfing').text() == '#'){
    		swal({
    			title: "목적지 폴더를 확인하셨나요?",
    			text: "잠시후 다시 시도해주세요!",
    			icon: "warning",
    			buttons: true,
    			dangerMode: true
    		});
    		return;
    	}
    	$.ajax({
    		url : "getmybookmark.do",
    		type:"POST",
    		data: {
    			url: $('.indishare-url-surfing').text(),
				urlname: $('.indishare-urlname-left').val(),
				pid: $('.indishare-userpid-left').val()
    		},
    		success : function(data){
    			if(data.result == "success") {
    				swal("Thank you!", "북마크에 추가되었습니다!", "success");
    				$('#socialSurfingModal').modal("toggle");
    			} else {
    				swal({
    					title: "목적지 폴더를 확인하셨나요?",
                        text: "잠시후 다시 시도해주세요!",
                        icon: "warning",
                        buttons: true,
                        dangerMode: true
    				});
    			}
    		},
    		error : function(error) {
    			swal({
    				title: "목적지 폴더를 확인하셨나요?",
                    text: "잠시후 다시 시도해주세요!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
    			});
    		}
		});
    });
    
    //[버튼]:그룹 북마크로 추가 버튼 클릭했을 때
    $('#into-group-bookmark-btn').on('dblclick', function(){});
	$('#into-group-bookmark-btn').on('click', function(){
		if($('.indishare-url-surfing').text() == '#'){
			swal({
				title: "목적지 폴더를 확인하셨나요?",
                text: "잠시후 다시 시도해주세요!",
                icon: "warning",
                buttons: true,
                dangerMode: true
			});
			return;
		}
		$.ajax({
			url : "getGroupBook.do",
			type: "POST",
			data: {
				url: $('.indishare-url-surfing').text(),
				urlname: $('.indishare-urlname-left').val(),
				pid: $('.indishare-userpid-left').val(), 
   				gid: $('.indishare-gid-left').val()
			},
			success : function(data){
				if(data.result == "success") {
					swal("Thank you!", "북마크에 추가되었습니다!", "success");
					$('#socialSurfingModal').modal("toggle");
				} else {
					swal({
						title: "목적지 폴더를 확인하셨나요?",
						text: "잠시후 다시 시도해주세요!",
	                    icon: "warning",
	                    buttons: true,
	                    dangerMode: true
					});
				}
			},
			error : function(error) {
				swal({
					title: "목적지 폴더를 확인하셨나요?",
                    text: "잠시후 다시 시도해주세요!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
				});
			}
		});
	});
})
    
//내 그룹리스트 중 하나를 선택 했을 때,
function seletedGroup(group, gid) {
	$('#dropdownMenuButton').text(group);
	$('.indishare-gid-left').val(gid);
	$('#into-my-bookmark-btn').css('display', 'none');
	$('#into-group-bookmark-btn').css('display', 'inline');
	$('#jstree-to-right-all').remove();
	$('.completed-modal-right-all').append('<div id="jstree-to-right-all"></div>');
	
	$.ajax({
		url : "../team/getGroupCategoryList.do",
		type:"POST",
		data: {gid: gid},
		dataType:"json",
		success : function(data){
			$("#jstree-to-right-all").jstree({
				"core": {
					'data' : data.data,
					'themes':{
						'name' : 'proton',
						'responsive' : true,
						"dots": false,
					}
				}
			
			}).bind("select_node.jstree", function (e, data) {
				var id = data.node.id;
				$('.indishare-userpid-left').val(id);
			});
		}
	});
}

/*진수 end*/