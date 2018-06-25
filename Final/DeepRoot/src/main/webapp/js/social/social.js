
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

	// portfolio filter
	$(window).load(function() {

		$('.main-slider').addClass('animate-in');
		$('.preloader').remove();
		// End Preloader

		if ($('.masonery_area').length) {
			$('.masonery_area').masonry(); // Masonry
		}

		var $portfolio_selectors = $('.portfolio-filter >li>a');

		if ($portfolio_selectors.length) {

			var $portfolio = $('.portfolio-items');
			$portfolio.isotope({
				itemSelector : '.portfolio-item',
				layoutMode : 'fitRows'
			});

			$portfolio_selectors.on('click', function() {
				$portfolio_selectors.removeClass('active');
				$(this).addClass('active');
				var selector = $(this).attr('data-filter');
				$portfolio.isotope({
					filter : selector
				});
				return false;
			});
		}
	});


	  $('.timer').each(count);

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

//링크 내 북마크로 가져가기 버튼 클릭
$('.getmybook').on('dblclick', function(){});
$('.getmybook').on('click', function(){
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
	    			html += '<li class="dropdown-group-item" onclick="seletedGroup(' 
    						+ "'" + data.teamlist[key].gname + "'" + ');"><span>'+ data.teamlist[key].gname + '</span></li><hr class="divider-hr">';
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
		url : "../user/getCategoryList.do",
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

// 나의 북마크로 추가 했을 때, 
$('#into-my-bookmark').on('dblclick', function(){});
$('#into-my-bookmark').on('click', function(){
	var params = $("#form-to-mybookmark").serialize();
	console.log("들어오긴 해????");
	$.ajax({
		url : "addtomybookmark.do",
		type:"POST",
		data: params,
		dataType:"json",
		success : function(data){
			console.log(data.result);
			console.log("오냐?");
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
			console.log("오냐?????");
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

//내의 그룹리스트 중 하나를 선택 했을 때,
function seletedGroup(group) {
$('#dropdownMenuButton').text(group);
}







/* mybookmark 가져오기 왼쪽 (폴더만 있는거) */
/*
$('.getmybook').on('dblclick', function(){ return });
$('.getmybook').on('click', function(){
	$.ajax({
		url : "../user/getCategoryList.do",
		type:"POST",
		dataType:"json",
		success : function(data){	
		console.log(data);
		 jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다. 					
		$("#indi-jstree-to-right").on("click",'.jstree-anchor',function(e){
			$('#indi-jstree-to-right').jstree(true).toggle_node(e.target);	
			})
			.jstree({	
					"core": {
						"dblclick_toggle" : false, // 두번 클릭해서 폴더여는거 false
					'data' : data, // ajax로 가져온 json data jstree에 넣어주기
				},
			})	
			.bind("loaded.jstree", function (event, data) {
				$('#indi-jstree-to-right').jstree("open_all");
					console.log("loaded jstree");
					var test = data.instance._model.data
					var head = 0;
			})
			.bind("select_node.jstree", function (e, data) {
					 노드(폴더)가 선택시 실행되는 함수 					
					var id = data.node.id;
					urlpid = id;
					// 선택된 노드(폴더)아래에 있는 url 가져오기
					$.ajax({
						url : "../user/getUrl.do",
						type : "POST",
						dataType:"json",
						data : {ubid : id},
						success : function(data){
							console.log(data);
							child_data = data;
							// 오른쪽에 있는 jstree 값 새로 넣어주고 refresh해주기
							$("#indi-jstree-to-right").jstree(true).settings.core.data = data;
							
						}
					})
			})
		}
	})
});*/

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
function testing_modal(d){
	
	console.log(d.id);
	$('.abc').text(d.id);
	var uid = d.id; // 클릭한 작성자 id 입니다.
	
	$.ajax({
		
		url : "getCategoryList.do",
		type : "POST",
		data : {uid : uid},	/* group id 를 넣어야 한다. */
		dataType :"json",
		success : function(obj){

			first_data = obj;
			$('#jstree-from-left-all').jstree(true).settings.core.data = obj;
			$('#jstree-from-left-all').jstree(true).refresh();
		}
	})
	
	$('#socialSurfingModal').modal();
};



$(document).ready(function(){
    
    var first_data = null;
    
//완료 그룹 모달 왼쪽 jstree
    $("#jstree-from-left-all").on('click','.jstree-anchor',function(e){
    $('#jstree-from-left-all').jstree(true).toggle_node(e.target);
        
    }).jstree({
            
            "core" : {
                "dblclick_toggle" : false,
                'data' : first_data,
                'themes':{
                    'name' : 'proton',
                    'responsive' : true,
                    'dots' : false,
                }
            }
            
        }).bind("select_node.jstree",function(event,data){
        	console.log(data.node.id);
        })

//완료 그룹 모달 오른쪽 jstree
     // 나의 북마크 선택했을 때, 
	    $('#dropdown-my-bookmark').on('dblclick', function(){});
	    $('#dropdown-my-bookmark').on('click', function(){
	    	// Modal init()
	    	$('#dropdownMenuButton').text($(this).text());
	    	$('#into-group-bookmark-btn').css('display', 'none');
	    	$('#jstree-to-right-all').remove();
	    	$('.completed-modal-right-all').append('<div id="jstree-to-right-all" style="float:right;"></div>');
	    	
	    	$.ajax({
				url : "../user/getCategoryList.do",
				type:"POST",
				dataType:"json",
				success : function(data){
					/*jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다.*/	
					$("#jstree-to-right-all").on("click",'.jstree-anchor',function(e){// 한번만 클릭해서 폴더 열기
						$('#jstree-to-right-all').jstree(true).toggle_node(e.target);
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
	 					console.log(data.node.id);
	 					
					});
				}
			});
	    });
	    
	    
	    
	 // 링크 내 북마크로 가져가기 버튼 클릭
		$('.table-write').on('dblclick', function(){});
	    $('.table-write').on('click', function(){
	    	// 모달 초기화 START
	    	$('#dropdownMenuButton').html("Click <span class='caret'></span>");
	    	$('#jstree-to-right-all').html('');
	    	$('#dropdown-empty-area').remove();	// 모달 초기화 END
	    	var url = $(this).parent().children('p').data('url');
	    	$('.indishare-url').val(url);
	    	$('.indishare-urlname').val($(this).parent().children('p').text());
	    	$('.indishare-abid').val( $(this).parent().children('p').data('abid'));
	    	
	    	// 진행중인 팀 리스트 가져오기
	    	$.ajax({
				url: "../team/getTeamList.do",
			    type: "post",
			    success : function(data){
			    	var html = '<ul class="dropdown-menu">';
			    	
			    	var index = 0;
			    	for(var key in data.teamlist){
			    		if(index == 0){
			    			html += '<li class="dropdown-group-item" onclick="seletedGroup('
			    					+ "'" + data.teamlist[key].gname + "', '" + data.teamlist[key].gid
			    					+ "');" + '"><span tabindex="-1">' + data.teamlist[key].gname
			    					+ '</span></li><hr class="divider-hr">';
			    		}else {
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
        
       
    })
    
// 내의 그룹리스트 중 하나를 선택 했을 때,
function seletedGroup(group, gid) {
	// Modal Init()
	$('#dropdownMenuButton').text(group);
	$('.indishare-gid').val(gid);
	$('#into-my-bookmark').css('display', 'none');
	$('#into-group-bookmark').css('display', 'block');
	$('#jstree-to-right-all').remove();
	$('.completed-modal-right-all').append('<div id="jstree-to-right-all" style="float:right;"></div>');
	
	$.ajax({
		url : "../team/getGroupCategoryList.do",
		type:"POST",
		data: {gid: gid},
		dataType:"json",
		success : function(data){
			// jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다.	
			$("#jstree-to-right-all").on("click",'.jstree-anchor',function(e){// 한번만 클릭해서 폴더 열기
				$('#jstree-to-right-all').jstree(true).toggle_node(e.target);
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
				console.log(data.node.id);
			});
		}
	});
}

/*진수 end*/
	
	