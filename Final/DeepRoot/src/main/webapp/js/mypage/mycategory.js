$(document).ready(function(){
			
			var urlpid = null;	//왼쪽 클릭된 폴더의 id
			var firstclick = 0;	//왼쪽 폴더 클릭 되었는지 확인용
			var child_data = null;	//오른쪽 url jstree data 담을 변수
			
/* mybookmark 가져오기 왼쪽 (폴더만 있는거) */
			$.ajax({
				url : "getCategoryList.do",
				type:"POST",
				dataType:"json",
				success : function(data){	
					console.log(data);

/*jstree 시작하기 jstree 생성하고 싶은 div의 id를 적어준다.*/					
					$("#jstree_container").on("click",'.jstree-anchor',function(e){// 한번만 클릭해서 폴더 열기
						$('#jstree_container').jstree(true).toggle_node(e.target);	
						
					})
					.jstree({	
							"core": {
								"dblclick_toggle" : false, // 두번 클릭해서 폴더여는거 false
							'data' : data, //ajax로 가져온 json data jstree에 넣어주기
							'themes':{
								'name' : 'proton', //테마 이름
								'responsive' : true,
								"dots": false, // 연결선 없애기
								
							},
							"check_callback" : function(op, node, par, pos, more){ // 특정 이벤트 실행 전에 잡아 낼 수 있음
								console.log(op);
								if(op === "move_node"){ // dnd 이벤트 일때 
									console.log(op);//move_node
									var dragnode = node.id;
									var dropnode = par.id;
									
									form = {dragnode : dragnode , dropnode : dropnode};
									
									$.ajax({
										
										url : 'dropNode.do',
										type : 'POST',
										data : form,
										success : function(data){
											console.log(data);
										}
									})
									return true;
								}else if(op === "create_node"){   //폴더 생성시 실행 되는 callback 함수
									
									$("#jstree_container_child").jstree(true).redraw_node(par, true); 
									return true;
								}else if(op == "copy_node"){	// 오른쪽 url 왼쪽 폴더로 옮기면 실행되는데 이때도 drag drop으로 처리함
									$.ajax({										
										url : 'dropNode.do',
										type : 'POST',
										data : {dragnode : node.id, dropnode : par.id},
										success : function(){
											$('#jstree_container').jstree().deselect_all(true);											
											$('#jstree_container').jstree(true).select_node(par.id);											
										}
									});
									return false;	
								}
								return true;	
							}
						},
						"plugins" : [ "dnd","contextmenu" ], //drag n drop , 과 우클릭시 플러그인 가져옴

						"contextmenu" : { //우클릭시 생성되는 것들 설정
							
							"select_node" : false, // 우클릭 했을 경우 왼클릭되는거 막음
							
/*우클릭시 생성되는 메뉴 구성하기 START*/
							
							"items" : function($node){ //우클릭된 node(폴더)의 정보를 가져온다.
						    	
						    	  var href = $node.a_attr.href;
						    	  
								  var tree = $("#jstree_container").jstree(true);
								  var tree_child = $("#jstree_container_child").jstree(true);
						    	  
									if(href == null || href == "#"){  
										// 링크 만들기, 폴더 만들기, 이름 바꾸기, 삭제
										return {
								            "link_create": {
								            	"icon" : "fa fa-plus",
								                "separator_before": false,
								                "separator_after": false,
								                "label": "URL 추가",
								                "action": function (obj) { 
								                	
								                	  $('#form')[0].reset();// modal input text 창 초기화
								                	  
									            	  var inst = $.jstree.reference(obj.reference); // 내가 우 클릭한 node의 정보
									            	  console.log(inst.get_node(obj.reference).id);// 내가 우 클릭한 node의 id 값 새로 생성하는 url의 부모id 값이 된다.
									            	  
									            	  $('#linkAdd').modal(); // url 추가하는 modal 창이 나온다.
									            	  
									            	  var par = inst.get_node(obj.reference).id; // 내가 우 클릭한 node의 id를 새로 생성하는 url의 부모로 지정
									            	  
									            	  $('#linkAddSubmit').on("click",function(){ // modal에서 보내기 선택한 것임
									            		  
									            		  var url = $('#url').val(); //추가 url 값
									            		  var title = $('#title').val(); // 추가 url 명값
									            		  var htag = $('#htag').val();
									            		  var sname = $.trim($('#sname').val());
									            		 // var parent = par;
									            		  console.log(url,title,par,htag,sname); //확인
									            		  
									            		  //공유 인지 아닌지는 htag 유무에 따라 결정됨
									            		  if($.trim(htag) == ""){
									            			  var form = {url : url , urlname : title , pid : par   }
									            		  }else{
									            			  var form = {url : url , urlname : title , pid : par,  htag : htag , sname : sname}
									            		  }
									            		  
									            		  $.ajax({
									            			  url: "addFolderOrUrl.do",
									            			  type :"POST",
									            			  data : form,
									            			  success : function(data){
									            					
									            				  $('#linkAdd').modal("toggle"); // 모달 창 닫아주기
									            				  var node_id = $.trim(data);
									            				  //db처리 후 view단에 url 생긴 것처럼 보이게 한다.
/*오른쪽 jstree에 url 생성해주기		*/							            				  
									            				  tree_child.create_node( null , {text : title , id : node_id , a_attr : {href : url} , icon : "https://www.google.com/s2/favicons?domain="+ url} ,"last",function(new_node){
									          				 		console.log(new_node.id);
									          				 	});
									            					console.log(data);	//id 확인
								              			  }
								          			  })
								          			})
								                }
								            },
								            "folder_create": {
								            	"icon" : "fa fa-plus-circle",
								                "separator_before": false,
								                "separator_after": false,
								                "_disabled"			: false, 
								                "label": "그룹 추가",
								                "action": function (obj) { 
								                	
								                	var inst = $.jstree.reference(obj.reference);
								                	var par_node = inst.get_node(obj.reference);
								                	
								                	var par = inst.get_node(obj.reference).id;
	 												var form = {urlname : "새 폴더", pid : par , }	// 해당 유저의 아이디 가져오기
	 												
								               		  $.ajax({
								            			  url: "addFolderOrUrl.do",
								            			  type :"POST",
								            			  data : form,
								            			  success : function(data){
								            				  
								            				 var node_id = $.trim(data)
/*새폴더 생성과 동시에 이름 수정하게 하기*/ 
								            				 	tree.create_node(par_node , {text : "새 폴더" , id : node_id  ,icon : "fa fa-folder"} ,"last",function(new_node){
								            				 		new_node.id = node_id;
								            				 		tree.edit(new_node);
								            				 	});
							              			 	 }
							          			 	})
								                }
								            },
								            "rename": {
								            	"icon" : "fa fa-edit",
								                "separator_before": false,
								                "separator_after": false,
								                "label": "이름 수정",
								                "action": function (obj) { 		
/*이름 수정하기 아래에 함수 있음*/
								                	tree.edit($node);			
								                }
								            },                         
								            "remove": {
								            	"icon" : "fa fa-trash",
								                "separator_before": false,
								                "separator_after": false,
								                "label": "삭제",
								                "action": function (obj) { 
													tree.delete_node($node);
								                }
								            }
								        };						
									}
                            }
                        }			    
					})	
					.bind("loaded.jstree", function (event, data) {
						$('#jstree_container').jstree("open_all");
							console.log("loaded jstree");
							var test = data.instance._model.data
							var head = 0;
					})
				.bind("select_node.jstree", function (e, data) {
/*노드(폴더)가 선택시 실행되는 함수*/					
	 					var id = data.node.id;
		
	 					urlpid = id;
	 					
	 					//선택된 노드(폴더)아래에 있는 url 가져오기
	 					$.ajax({
	 						
	 						url : "getUrl.do",
	 						type : "POST",
	 						dataType:"json",
	 						data : {ubid : id},
	 						success : function(data){

	 							child_data = data;
	 							//오른쪽에 있는 jstree 값 새로 넣어주고 refresh해주기
	 								$("#jstree_container_child").jstree(true).settings.core.data = data;
	 								$("#jstree_container_child").jstree(true).refresh();
								}
	 					})
					}) 
			    	.bind('rename_node.jstree', function(event, data){
			    		var node_id = data.node.id;
			    		var node_text = data.text;
/*이름 수정하기*/			    		
			    		$.ajax({
		        			url : 'updateNodeText.do',
		        			type: 'POST',
		        			data: {'id' : node_id, 'text' : node_text},
		        			success : function(result){
		        				if(result == 1)
		        					alert('수정되었습니다.');
		        				else
		        					alert('수정 실패');
		        			}
		        		});   
			    	})
			    	.bind('before_open.jstree',function(obj,stric,c){
			    		
			    	})
			    	.bind('delete_node.jstree',function(event,data){
/*삭제하기*/
			    		var node_id = data.node.id;
			    		var form = {node : node_id}
			    		
	 		    		$.ajax({
			    			url:'deleteNode.do',
			    			type:'POST',
			    			dataType : "json",
			    			data: form,
			    			success:function(result){
			    				console.log(result);
			    				}
			    		})  
			    	})	;
				}
			})
			
/*왼쪽 위에 new category 버튼 클릭시 실행*/			
			$('#addroot').on("click",function(){
				
				  var tree = $("#jstree_container").jstree(true);
				  
				  $.ajax({
						
					  url : "addRoot.do",
					  type : "POST",
					  success : function(data){
						  
						  var ubid = $.trim(data);
						  //root 카테로기 생성
						  tree.create_node( null , {text : "새 카테고리" , id : ubid , icon : "fa fa-folder"} ,"last",function(new_node){
							  new_node = ubid;
							  tree.edit(new_node); //생성과 동시에 이름 수정할 수 있게 함
	      				 	});
					  }
				  })
			})
/*오른쪽 위에 url 추가하기 버튼 클릭시 실행 됨*/			
			$("#addurl").on("click",function(){
				
				var tree_child = $("#jstree_container_child").jstree(true);
				
				//왼쪽 폴더 선택 안하고 클릭한 것을 방지한다.
				if(urlpid == null){
					alert("노드를 선택해 주세요");
					return false;
				}

// 모달창 띄우기 전에 reset하기
          	  $('#form_btn')[0].reset();// modal input text 창 초기화
          	  
          	  $('#linkAdd_btn').modal(); // url 추가하는 modal 창이 나온다.
          	  
          	  var par =urlpid; // 내가 우 클릭한 node의 id를 새로 생성하는 url의 부모로 지정
          	  
           	  $('#linkAddSubmit_btn').on("click",function(){ // modal에서 보내기 선택한 것임
          		  
          		  var url = $('#url_btn').val(); //추가 url 값
          		  var title = $('#title_btn').val(); // 추가 url 명값
          		  var htag = $('#htag_btn').val();
        		  var sname = $.trim($('#sname_btn').val());
          		 // var parent = par;
          		  console.log(url,title,par,sname,htag); //확인
          		  
          		  if($.trim($('#htag_btn').val())==""){
          		  var form = {url : url , urlname : title , pid : urlpid};
          		  }else{
          			var form = {url : url , urlname : title , pid : urlpid , htag : htag , sname : sname};
          		  }
          		  $.ajax({
          			  url: "addFolderOrUrl.do",
          			  type :"POST",
          			  data : form,
          			  success : function(data){
          				  $('#linkAdd_btn').modal("toggle"); // 모달 창 닫아주기
          					var node_id = $.trim(data);
          					//오른쪽 url 생성해 주기
          					tree_child.create_node( null , {text : title , id : node_id , a_attr : {href : url} , icon : "https://www.google.com/s2/favicons?domain="+ url} ,"last",function(new_node){
        				 	});
        			  }
    			  })
    			}) 
				
			});

/*오른쪽 jstree 생성*/
			$("#jstree_container_child").jstree({
					
					"core" : {
						'data' : child_data,
						'themes' : { 
							'name' : 'proton',
							'responsive' : true,
							"dots": false
						},
						"check_callback" : function(op, node, par, pos, more){
							if(op === "move_node"){ // dnd 이벤트 일때 
								return false;
							}							
							return true;	
						}
					},
					"plugins" : [ "dnd","contextmenu" , "wholerow"],
					
					"contextmenu" : {
						
						"select_node" : false,
						"items" : function($node){
							
							var tree_child = $("#jstree_container_child").jstree(true);
							
							console.log($node.original.htag);
							var htag = $node.original.htag;
							
							if(htag == '#'){
							
							return{
////////////////////////////////////공유하기 버튼 만들기								
								"edit" : {
									"icon" : "fa fa-edit",
									 "separator_before": false,
						              "separator_after": false,
						              "label" : "수정",
						              "action" : false,
						              "submenu" :{
						            	  "rename" : {
						            		  "separator_before"	: false,
												"separator_after"	: false,
												"label" : "이름 수정",
												"action" : function(obj){
													console.log("d이름수정");
								                	tree_child.edit($node);
												}
						            	  },
						            	  
						            	  "editurl" : {
						            		  "separator_before"	: false,
												"separator_after"	: false,
						                		"label" : "URL 수정",
						                		"action" : function(obj){
						                			
						                			
								                	$('#form3')[0].reset();	// url 모달창 reset
								                	$('#editurl').modal();	//url 수정 모달창 띄우기
								                	 
								                	var inst = $.jstree.reference(obj.reference);
									                var url = inst.get_node(obj.reference).a_attr.href;
									                var id = inst.get_node(obj.reference).id;
									                
								                	 console.log(url);
								                	 $('#editurlval').val(url);
								                	 
								                	 $('#editurlsubmit').on("click",function(){
								                		 
								                		 var newurl = $('#editurlval').val();
								                		 var form = {ubid : id, url : newurl }
								                		 
								                		 $.ajax({
									                		 
									                		 url: "editUrl.do",
									                		 type: "POST",
									                		 data: form ,
									                		 success: function(data){
									                			 console.log(data);
									                			 $('#editurl').modal("toggle");
									                			 
									                			 
									                		 }
									                	 }) 
								                	 })
						                		}
						            	  }
						              }
								},
						            "remove": {
						            	"icon" : "fa fa-trash",
						                "separator_before": false,
						                "separator_after": false,
						                "label": "삭제",
						                "action": function (obj) { 
						                	
						                  	console.log("누름");
						                  	tree_child.delete_node($node);
						                }
						            },
						            "recommend" :{
						            	"separator_before": false,
						                "separator_after": false,
						                "label": "관리자 추천",
						                "action": function (obj) { 
						                	
							               	var inst = $.jstree.reference(obj.reference);
							                var url = inst.get_node(obj.reference).a_attr.href;
							                var text = inst.get_node(obj.reference).text;
							                
							                form = {url : url , text : text }
							                
							                $.ajax({
							                	
							                	url : "recommend.do",
							                	type : "POST",
							                	data : form,
							                	success : function(data){
							                		
							                		console.log(data);
							                		
							                	}
							                })
						                }
						            }
				                 }		
							}else{
								
								return{
									
									"edit" : {
										"icon" : "fa fa-edit",
										 "separator_before": false,
							              "separator_after": false,
							              "label" : "수정",
							              "action" : false,
							              "submenu" :{
							            	  "rename" : {
							            		  "separator_before"	: false,
													"separator_after"	: false,
													"label" : "이름 수정",
													"action" : function(obj){
														console.log("d이름수정");
									                	tree_child.edit($node);
													}
							            	  },
							            	  
							            	  "editurl" : {
							            		  "separator_before"	: false,
													"separator_after"	: false,
							                		"label" : "URL 수정",
							                		"action" : function(obj){
							                			
							                			
									                	$('#form3')[0].reset();	// url 모달창 reset
									                	$('#editurl').modal();	//url 수정 모달창 띄우기
									                	 
									                	var inst = $.jstree.reference(obj.reference);
										                var url = inst.get_node(obj.reference).a_attr.href;
										                var id = inst.get_node(obj.reference).id;
										                
									                	 console.log(url);
									                	 $('#editurlval').val(url);
									                	 
									                	 $('#editurlsubmit').on("click",function(){
									                		 
									                		 var newurl = $('#editurlval').val();
									                		 var form = {ubid : id, url : newurl }
									                		 
									                		 $.ajax({
										                		 
										                		 url: "editUrl.do",
										                		 type: "POST",
										                		 data: form ,
										                		 success: function(data){
										                			 console.log(data);
										                			 $('#editurl').modal("toggle");
										                		 }
										                	 }) 
									                	 })
							                		}
							            	  }
							              }
									},
						            "remove": {
						            	"icon" : "fa fa-trash",
						                "separator_before": false,
						                "separator_after": false,
						                "label": "삭제",
						                "action": function (obj) { 
						                	
						                  	tree_child.delete_node($node);
						                }
						            },
						            "recommend" :{
						            	"separator_before": false,
						                "separator_after": false,
						                "label": "관리자 추천",
						                "action": function (obj) { 
						                	
							               	var inst = $.jstree.reference(obj.reference);
							                var url = inst.get_node(obj.reference).a_attr.href;
							                var text = inst.get_node(obj.reference).text;
							                
							                form = {url : url , text : text }
							                
							                $.ajax({
							                	
							                	url : "recommend.do",
							                	type : "POST",
							                	data : form,
							                	success : function(data){
							                		
							                		console.log(data);
							                	}
							                })
						                }
						            },
						            "share":{
						            	   "icon" : "fa fa-share",
						            	   "separator_before": true,
							               "separator_after": false,
							                "label": "공유",
							                "action"			: false,
							                "submenu" :{
							                	"editing" :{
							                		"separator_before"	: false,
													"separator_after"	: false,
							                		"label": "수정하기",
							                		"action" : function(data){
///////////공유 수정하기////////////////							                			
							                		}
							                	},
							                	"dimiss" :{
							                		"separator_before"	: false,
													"separator_after"	: false,
							                		"label" : "취소하기",
							                		"action" : function(obj){
							                			var inst = $.jstree.reference(obj.reference);
							                			var id = inst.get_node(obj.reference).id;
///////////////////////////////////////////공유 취소하기/////////////		
//////////////////redraw 해야 한다. refresh 이든/////////////////
																$.ajax({
																	url: 'shareUrlEdit.do',
																	type: 'POST',
																	data: {ubid: id },
																	success:function(data){
																		console.log(data);
																		}
																	})
							                				}
							                		}
							                	
							                }
						            }
						            
				                 }
							}
						}
					}
				})
				.bind("select_node.jstree",function(e,data){
					var href = data.node.a_attr.href;
					
					window.open(href); 
					$('#jstree_container_child').jstree().deselect_all(true);			
					
				}) 
				.bind("delete_node.jstree",function(event,data){
					
					var node_id = data.node.id;
					var form = {node : node_id}
	
					$.ajax({
					url:'deleteNode.do',
					type:'POST',
					dataType : "json",
					data: form,
					success:function(result){
						console.log(result);
					}
		
			})  
		})
		.bind('rename_node.jstree', function(event, data){
			 var node_id = data.node.id;
			var node_text = data.text;
			console.log(node_id);
			console.log(node_text);
			
			$.ajax({
				url : 'updateNodeText.do',
				type: 'POST',
				data: {'id' : node_id, 'text' : node_text},
				success : function(result){
					if(result == 1)
						alert('수정되었습니다.');
					else
						alert('수정 실패');
														}
					});   
		})

	$("#jstree_container").on('select_node.jstree',function(e,data){
	})
/*폴더 열렸을 경우 아이콘 변경해 주기*/	
	$("#jstree_container").on('open_node.jstree', function(e,data){
		$.jstree.reference('#jstree_container').set_icon(data.node, "fa fa-folder-open")
	})
/*폴더 닫혔을 경우 아이콘 변경해 주기*/
	$("#jstree_container").on('close_node.jstree', function(e,data){
		$.jstree.reference('#jstree_container').set_icon(data.node, "fa fa-folder")
	})

	$("#jstree-from-left").on('open_node.jstree', function(e,data){
	$.jstree.reference('#jstree-from-left').set_icon(data.node, "fa fa-folder-open")
	})
	$("#jstree-from-left").on('close_node.jstree', function(e,data){
		$.jstree.reference('#jstree-from-left').set_icon(data.node, "fa fa-folder")
	})
	
	$("#jstree-to-right").on('open_node.jstree', function(e,data){
	$.jstree.reference('#jstree-to-right').set_icon(data.node, "fa fa-folder-open")
	})
	$("#jstree-to-right").on('close_node.jstree', function(e,data){
		$.jstree.reference('#jstree-to-right').set_icon(data.node, "fa fa-folder")
	})
	
});

