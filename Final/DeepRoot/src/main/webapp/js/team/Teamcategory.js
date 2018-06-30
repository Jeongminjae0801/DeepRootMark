var urlpid = null;
var gid2 = null;
function jstree(role , gid, uid,nname){
	gid2 =gid;
	form = {gid : gid}
	/* 그룹 시작시 jstree 가져오기 */
	$.ajax({
		url : "getTeamJstree.do",
		type:"POST",
		data :form,
		dataType:"json",
		success : function(data){	
			/*왼쪽 jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다.*/					
			$("#jstree_container")
				.jstree({	
					"core": {
						"data" : data, //ajax로 가져온 json data jstree에 넣어주기
						'themes':{
							'name' : 'proton', //테마 이름
							'responsive' : true,
							"dots": false, // 연결선 없애기
						},
						"check_callback" : function(op, node, par, pos, more){ // 특정 이벤트 실행 전에 잡아 낼 수 있음
							console.log("//////////////////");
							console.log(par);
							console.log(pos); // 수정시 새이름 들어옴 //rename_node  일경우에만 보내야만
							console.log(more);
							console.log("more 위 위");
							console.log(node);
							
							var type= '#';
							var newnameorplace = '#';
							
							if(node.a_attr.href =='#')
								type='폴더';
							else
								type='URL';
							
												
							if(op=='move_node'){
							// dnd 일경우 more.core =ture 일 경우에만 메세지 보내기
								if(more.core){
									newnameorplace = pos.text
									
									sendmessage()
								}//dnd 성공
								
								
							}else if	(op == 'rename_node'){
								newnameorplace = pos;
								sendmessage()
							}else if(op =='delete_node'){
								sendmessage()
							}else if(op == 'create_node'){
								sendmessage()
							}
							
							function sendmessage() {
								
								var op_msg = "";
		                        
		                        switch(op){
		                            case 'create_node':   op_msg = "생성"; break;
		                            case 'rename_node':   op_msg = "수정"; break;
		                            case 'delete_node':   op_msg = "삭제"; break;
		                            case 'move_node':   op_msg = "이동"; break;
		                        }
								
								stompClient.send("/JSTREE/" + gid, {}, JSON.stringify({
						           	doing : op_msg,
						           	target : node.text,
						           	location : par.text,
						           	nname: nname,
						           	type : type,
						           	newnameorplace :newnameorplace
						        }));
							}
							
							//권한 검사해서 DND 가능자와 아닌자 구분
							if(op === "move_node"){ // dnd 이벤트 일때 
								var dragnode = node.id;
								var dropnode = par.id;
								
								form = {dragnode : dragnode , dropnode : dropnode};
								
								$.ajax({	
									
									url : 'dropTeamNode.do',
									type : 'POST',
									data : form,
									beforeSend : function(){
									},
									success : function(data){
									}
								})
								return true;
							}
							return true;	
						}
					},
					"plugins" : [ "dnd","contextmenu" ], //drag n drop , 과 우클릭시 플러그인 가져옴

					"contextmenu" : { //우클릭시 생성되는 것들 설정
						"select_node" : false, // 우클릭 했을 경우 왼클릭되는거 막음
						
						/*왼쪽 jstree  우클릭시 생성되는 메뉴 구성하기 START*/
						"items" : function($node){ //우클릭된 node(폴더)의 정보를 가져온다.
							
							var node_uid = $node.original.uid;
							var href = $node.a_attr.href;
							var tree = $("#jstree_container").jstree(true);
							console.log(role);
							if(role == 3){ //일반 회원
								
								if(node_uid == uid){ // 선택한 노드가 내가 생성한 것이라면
									if(href =='#'){	//선택한 노드가 폴더일 경우

										return {	
											"link_create" : {
												"icon" : "fa fa-plus",
												"separator_before": false,
												"separator_after": false,
												"label": "URL 추가",
												"action": function (obj) { 
													
													var inst = $.jstree.reference(obj.reference);
													var par_node = inst.get_node(obj.reference);
													urlpid = inst.get_node(obj.reference).id;
													
													$('#form_btn')[0].reset();// modal input text 창 초기화
													$('#linkAdd_btn').modal();
													addUrlLevel1();
													
												}
											},
											"folder_create": {
												"icon" : "fa fa-plus-circle",
												"separator_before": false,
												"separator_after": false,
												"_disabled" : false, 
												"label": "그룹 추가",
												"action": function (obj) {
													var inst = $.jstree.reference(obj.reference);
													var par_node = inst.get_node(obj.reference);
													var par = inst.get_node(obj.reference).id;
													var form = {urlname : "새 폴더", pid : par ,gid:gid};// 해당 유저의 아이디 가져오기
													
													$.ajax({
														url: "addTeamFolderOrUrl.do",
														type :"POST",
														data : form,
														beforeSend : function(){
										     				},
										     				success : function(data){
										     					var node_id = $.trim(data.result);
										     					tree.create_node(par_node , {text : "새 폴더" , id : node_id  ,icon : "fa fa-folder",uid: uid ,a_attr : {href: '#'}} ,"last",function(new_node){
										     						new_node.id = node_id;
										     						tree.edit(new_node);
									            				});
								              			 	 }
													})
												}
											},
											"rename" : {
												"icon" : "fa fa-edit",
												"separator_before": false,
												"separator_after": false,
												"label": "이름 수정",
												"action" : function (obj) {
													/*왼쪽 jstree 이름 수정하기 아래에 함수 있음*/
													tree.edit($node);			
												}
											}
										}
									}else{ //선택한 노드가 url 일경우
										
										return{
											"rename" : {
												"icon" : "fa fa-edit",
												"separator_before": false,
												"separator_after": false,
												"label": "이름 수정",
												"action" : function (obj) {
													/*왼쪽 jstree 이름 수정하기 아래에 함수 있음*/
													tree.edit($node);			
												}
											},
											//url 수정 메뉴 만들기
											"remove" : {
												"icon" : "fa fa-trash",
												"separator_before": false,
												"separator_after": false,
												"label": "삭제",
												"action": function (obj) { 
													tree.delete_node($node);
												}
											}
										}
									}			
								}else{//선택한 노드가 내가 생성한 것이 아니라면
									if(href=='#'){// 선택한 노드가 폴더 일 경우
										return{
											"link_create" : {
												"icon" : "fa fa-plus",
												"separator_before": false,
												"separator_after": false,
												"label": "URL 추가",
												"action": function (obj) { 
													
													var inst = $.jstree.reference(obj.reference);
													var par_node = inst.get_node(obj.reference);
													urlpid = inst.get_node(obj.reference).id;
													
													$('#form_btn')[0].reset();// modal input text 창 초기화
													$('#linkAdd_btn').modal();
													addUrlLevel1();
													
												}
											},
											"folder_create": {
												"icon" : "fa fa-plus-circle",
												"separator_before": false,
												"separator_after": false,
												"_disabled" : false, 
												"label": "그룹 추가",
												"action": function (obj) {
													var inst = $.jstree.reference(obj.reference);
													var par_node = inst.get_node(obj.reference);
													var par = inst.get_node(obj.reference).id;
													var form = {urlname : "새 폴더", pid : par ,gid:gid};// 해당 유저의 아이디 가져오기
													
													$.ajax({
														url: "addTeamFolderOrUrl.do",
														type :"POST",
														data : form,
														beforeSend : function(){
										     				},
										     				success : function(data){
										     					var node_id = $.trim(data.result);
										     					tree.create_node(par_node , {text : "새 폴더" , id : node_id  ,icon : "fa fa-folder",uid: uid ,a_attr : {href: '#'}} ,"last",function(new_node){
										     						new_node.id = node_id;
										     						tree.edit(new_node);
									            				});
								              			 	 }
													})
												}
											}
										}
									}else{//선택한 노드가 url 일 경우
										return false;
									}
								}
							}else{ //매니저 혹은 그룹장
								// 링크 만들기, 폴더 만들기, 이름 바꾸기, 삭제
								if(href =='#'){ //폴더 일 경우
									return {
										"link_create" : {
											"icon" : "fa fa-plus",
											"separator_before": false,
											"separator_after": false,
											"label": "URL 추가",
											"action": function (obj) { 
												
												var inst = $.jstree.reference(obj.reference);
												var par_node = inst.get_node(obj.reference);
												urlpid = inst.get_node(obj.reference).id;
												
												$('#form_btn')[0].reset();// modal input text 창 초기화
												$('#linkAdd_btn').modal();
												addUrlLevel1();
												
											}
										},
										"folder_create": {
											"icon" : "fa fa-plus-circle",
											"separator_before": false,
											"separator_after": false,
											"_disabled" : false, 
											"label": "그룹 추가",
											"action": function (obj) {
												var inst = $.jstree.reference(obj.reference);
												var par_node = inst.get_node(obj.reference);
												var par = inst.get_node(obj.reference).id;
												var form = {urlname : "새 폴더", pid : par ,gid:gid};// 해당 유저의 아이디 가져오기
												
												$.ajax({
													url: "addTeamFolderOrUrl.do",
													type :"POST",
													data : form,
													beforeSend : function(){
									     				},
									     				success : function(data){
									     					var node_id = $.trim(data.result);
									     					tree.create_node(par_node , {text : "새 폴더" , id : node_id  ,icon : "fa fa-folder",uid: uid ,a_attr : {href: '#'}} ,"last",function(new_node){
									     						new_node.id = node_id;
									     						tree.edit(new_node);
								            				 	});
							              			 	 	}
								               		  	})
											}
										},
										"rename" : {
											"icon" : "fa fa-edit",
											"separator_before": false,
											"separator_after": false,
											"label": "이름 수정",
											"action" : function (obj) {
												/*왼쪽 jstree 이름 수정하기 아래에 함수 있음*/
												tree.edit($node);			
											}
										},
										"remove" : {
											"icon" : "fa fa-trash",
											"separator_before": false,
											"separator_after": false,
											"label": "삭제",
											"action": function (obj) { 
												tree.delete_node($node);
											}
										}
									};	
								}else{//url 일 경우
									return{
										"rename" : {
											"icon" : "fa fa-edit",
											"separator_before": false,
											"separator_after": false,
											"label": "이름 수정",
											"action" : function (obj) {
												/*왼쪽 jstree 이름 수정하기 아래에 함수 있음*/
												tree.edit($node);			
											}
										},
										"remove" : {
											"icon" : "fa fa-trash",
											"separator_before": false,
											"separator_after": false,
											"label": "삭제",
											"action": function (obj) { 
												tree.delete_node($node);
											}
										}
									}
									
								}
							}
						}
					}			    
				})	
				.bind("loaded.jstree", function (event, data) {
					$('#jstree_container').jstree("open_all");
					var test = data.instance._model.data
				})
				.bind("select_node.jstree", function (e, data) {
					console.log(data);
				}) 
			    .bind('rename_node.jstree', function(event, data){
		    		var node_id = data.node.id;
		    		var node_text = data.text;
		    		/*왼쪽 jstree 폴더 이름 수정하기*/			    		
		    		$.ajax({
	        			url : 'updateTeamNodeText.do',
	        			type: 'POST',
	        			data: {'gbid' : node_id, 'text' : node_text},
	        			beforeSend : function(){
     					},
	        			success : function(result){
	        				console.log(result.result);
	        			}
	        		});   
		    	})
		    	.bind('delete_node.jstree',function(event,data){
			    		/*왼쪽 jstree 폴더 삭제하기*/
		    		var node_id = data.node.id;
		    		var form = {gbid : node_id}
		    		
		    		$.ajax({
		    			url:'deleteTeamNode.do',
		    			type:'POST',
		    			dataType : "json",
		    			data: form,
		    			beforeSend : function(){
     					},
     					success : function(result){
     						console.log(result.result);
						}
					})  
		    	})
		    	.bind("select_node.jstree",function(e,data){
		    		var href = data.node.a_attr.href;
		    		
		    		if(href !='#'){
						window.open(href); 
						$('#jstree_container_child').jstree().deselect_all(true);	
		    		}
			
		    	})
		}
	})
	/*왼쪽 jstree 폴더 열렸을 경우 아이콘 변경해 주기*/	
	$("#jstree_container").on('open_node.jstree', function(e,data){
		$.jstree.reference('#jstree_container').set_icon(data.node, "fa fa-folder-open")
	})
	/*왼쪽 jstree 폴더 닫혔을 경우 아이콘 변경해 주기*/
	$("#jstree_container").on('close_node.jstree', function(e,data){
		$.jstree.reference('#jstree_container').set_icon(data.node, "fa fa-folder")
	})	
}

function addUrlLevel1() {
	$(".addUrlLevel1").show();
	$(".addUrlLevel2").hide();
	$(".addUrlLevel2").hide();
}

function openAddUrlLevel2() {
	
	var url = $("#url_btn").val().trim();
	
	if(url == ""){
		$.alert("URL을 입력해주세요");
	}else {
		$.ajax({
    		url: "/bit/admin/preview.do",
			type: "post",
			data : {
				url : url // URL 주소
			},
			beforeSend: function() {
				
				$("#title_btn").css("cursor", "wait ");
         		$("#title_btn").val("");
         		//console.log("부모 ID : " + urlpid);
         		
         		var text = $('#jstree_container').jstree(true).get_node(urlpid).text;
         		//console.log("카테고리 : " + text + "/////")
         		$("#category_btn").val(text);
         		addUrlLevel2();
            },
            complete: function() {
            	$("#title_btn").css("cursor", "default");
            },
			success : function(data){
				$("#title_btn").val(data.title);
			},
    	});
	}
	
}

//2단계 폼 보여주기
function addUrlLevel2() {
	$(".addUrlLevel2").show();
	$(".addUrlLevel1").hide();
}

//url 추가
function addUrl(){
	var url = $('#url_btn').val(); //추가 url 값
	var title = $('#title_btn').val(); // 추가 url 명값
	var tree = $("#jstree_container").jstree(true);
	var form = {url : url , urlname : title , pid : urlpid, gid:gid2}
	console.log(form);
	 if(title == ""){
		 $.alert("제목을 입력해주세요")
	 }else {
	$.ajax({
		url: "addTeamFolderOrUrl.do",
		type :"POST",
		data : form,
		beforeSend : function(){
				},
				success : function(data){
					$('#linkAdd_btn').modal("toggle"); 
					var par_node = $('#jstree_container').jstree(true).get_node(urlpid);
					var node_id = $.trim(data.result);
					tree.create_node(par_node , {text : title , id : node_id  , icon : "https://www.google.com/s2/favicons?domain="+ url ,uid: uid ,a_attr : {href: url}} ,"last",function(new_node){
				 	});
			 	 	}
   		  	})
	 }
	
}
