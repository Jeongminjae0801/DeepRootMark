/* 멤버 초대 */
function member_insert(){
    $.confirm({
        title: '멤버 초대',
        content: '' +
        '<form id="insertMember" action="" class="formGroup" method="post">' +
        '<div class="form-group">' +
        '<label>추가 할 멤버의 닉네임 입력하세요</label>' +
        '<input type="text" name="nname" class="insertName form-control"/>' +
        '</div>' +
        '</form>',
        closeIcon: true,
        closeIconClass: 'fa fa-close',
        buttons: {
        	'초대하기': {
                btnClass: 'btn-success',
                action: function () {
                    var toid = this.$content.find('.insertName').val();
                    console.log(name);
                    
                    if(!toid){
	                    $.alert('이메일을 적어주세요');
	                    return false;
	                }

                    $.ajax({
                		url: "invite.do",
            			type: "post",
            			data : { toid : toid, gid: gid },
            			success : function(data){
            				console.log(data.result);
            				if(data.result == "success") {
            					$.alert("초대 쪽지가 전달되었습니다!" + "\n(" + toid + ")");
            					
            				} else if(data.result == "fail") {
            					$.alert("존재하지 않는 이메일입니다!");
            				} else {
            					$.alert("이미 초대된 사용자입니다!");
            				}
            			}
                	});

                }
            },
            '취소': {
                btnClass: 'btn-red',
                action: function () {
                //close
                }
            }
        }
    });
}

$(function() {
	$(".insertName").autocomplete({
		source: function() {
					$.ajax({
			    		url: "allUserNname.do",
						type: "post",
						data: {nname:$(".insertName").val()},
						dataType: "json",
						success : function(data){
							console.log(data.nname);
							return data.nname;
						}
			    	});
				},
		select: function( event, ui ) {
            // 검색리스트에서 선택하였을때, 
			$('.insertName').val(ui.item.label);
        }
    });
	
});


/* 멤버 초대 END */

/* 그룹 탈퇴 */
function group_leave(){
    $.confirm({
        title: '그룹 탈퇴',
        content: '' +
        '<form id="leaveGroup" action="" class="formGroup" method="post">' +
        '<div class="form-group">' +
        '<label>그룹을 탈퇴하시겠습니까</label>' +
        '<input type="hidden" name="nname" class="leaveName form-control"/>' +
        '</div>' +
        '</form>',
        closeIcon: true,
        closeIconClass: 'fa fa-close',
        buttons: {
            formSubmit: {
                text: '탈퇴',
                btnClass: 'btn-success',
                action: function () {
                    var name = this.$content.find('.leaveName').val();

                    $("#leaveGroup").submit();

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
function group_complete(){
    $.confirm({
        title: '그룹 완료',
        content: '' +
        '<form id="completeGroup" action="" class="formGroup" method="post">' +
        '<div class="form-group">' +
        '<label>해시태그를 입력하세요</label>' +
        '<input type="text" name="htag" class="htagName form-control" required/>' +
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
                    var name = this.$content.find('.htagName').val();
                    if(!name){
	                    $.alert('해시태그를 적어주세요');
	                    return false;
	                }

                    $("#completeGroup").submit();

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