/* 멤버 초대 */
function member_insert(){
$.confirm({
		    title: '멤버 초대',
		    content: '' +
		    '<form id="" action="" class="" method="post">' +
		    '<label>추가 할 멤버의 닉네임 입력하세요</label>' +
		    '<input type="text" name="" class="member_insert_input"/>' +
		    '</form>',
		    theme: 'light',
			type: 'green',
		    closeIcon: true,
		    buttons: {
		        formSubmit: {
		            text: '초대',
		            btnClass: 'btn-green',
		            action: function () {
		                var name = this.$content.find('.name').val();
		                
		                $("#form id 적어줘").submit();
		                
		            }
		        },
		        '취소': {
		            btnClass: 'btn-red',
		            action: function () {
		            //close
		            }
		        },
		    }
		});
}

/* 그룹 탈퇴 */
function group_out(){
$.confirm({
		    title: '그룹 탈퇴',
		    content: '' +
		    '<form " action="" class="" method="post">' +
		    '<label>그룹을 탈퇴하시겠습니까</label>' +
		    '</form>',
		    theme: 'light',
			type: 'green',
		    closeIcon: true,
		    buttons: {
		        formSubmit: {
		            text: '탈퇴',
		            btnClass: 'btn-green',
		            action: function () {
		                var name = this.$content.find('.name').val();
		                
		                $("#form id 적어줘").submit();
		                
		            }
		        },
		        '취소': {
		            btnClass: 'btn-red',
		            action: function () {
		            //close
		            }
		        },
		    }
		});
}



/* 그룹 완료 */
function () {
	$.confirm({
	    title: '그룹 완료',
	    content: '' +
	    '<form id="" action="" class="" method="post">' +
	    '<div class="">' +
	    '<label>해시태그</label>' +
	    '<input type="text" name="htag" placeholder="#해쉬태그" class="" required />' +
	    '<input type="hidden" class="gid" name="gid" />' + 
	    '</div>' +
	    '</form>',
	    closeIcon: true,
	    closeIconClass: 'fa fa-close',
	    
	    buttons: {
	        formSubmit: {
	            text: '완료',
	            btnClass: 'btn-success',
	            action: function () {
	                var name = this.$content.find('.name').val();
	                this.$content.find('.gid').val(gid);
	                if(!name){
	                    $.alert('해시태그를 적어주세요');
	                    return false;
	                }

	                $("#id 입력하세여").submit();
	                
	            }
	        },
	        '취소': {
	        	btnClass : 'btn-danger',
        		action : function() {
        		}
	        },
	    }
	    
	});
}

