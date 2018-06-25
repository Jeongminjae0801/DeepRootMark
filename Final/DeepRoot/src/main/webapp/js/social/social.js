
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
/* mybookmark 가져오기 왼쪽 (폴더만 있는거) */
/*$('#completed-modal-mybook').on('dblclick', function(){ return });*/


/*function mycategory(){*/
$('.gogosing').on('click', function(){
	console.log("쉣");
	$.ajax({
		url : "getCategoryList.do",
		type:"POST",
		dataType:"json",
		success : function(data){	
		console.log("들어오긴해?");
		console.log(data);
		/* jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다. */					
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
					/* 노드(폴더)가 선택시 실행되는 함수 */					
					var id = data.node.id;
					urlpid = id;
					// 선택된 노드(폴더)아래에 있는 url 가져오기
					$.ajax({
						url : "getUrl.do",
						type : "POST",
						dataType:"json",
						data : {ubid : id},
						success : function(data){
							child_data = data;
							// 오른쪽에 있는 jstree 값 새로 넣어주고 refresh해주기
							$("#indi-jstree-to-right").jstree(true).settings.core.data = data;
							$("#indi-jstree-to-right").jstree(true).refresh();
						}
					})
			})
		}
	})
});

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
       
    })
/*진수 end*/
	
	