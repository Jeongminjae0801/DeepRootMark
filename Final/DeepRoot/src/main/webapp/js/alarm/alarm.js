
/* 초대 수락 */
function inviteOk(){
	$()
	
}
/* 쪽지 없애기 */
function deleteMemo(gid, fromid, alarm_kind){
	var alarm_item = $(this).parent();
	console.log(alarm_item);
	var gaid = 0;
	if(alarm_kind == '강퇴') {gaid = 3;}
	else if(alarm_kind == '완료') {gaid = 2;}
	else {gaid = 1;}
	$.ajax({
		url: "/bit/alarm/deleteMemo.do",
		type: "post",
		data : { gid: gid, fromid: fromid, gaid: gaid },
		success : function(data){
			console.log(data.result);
			if( data.result == "deleted" ) {
				alarm_item.remove();
				$.alert("정상적으로 처리되었습니다");
			}else {
				$.alert("잠시후 다시 시도해주세요");
			}
		}
	});
	//$(this).parent().remove();
	
}


$(function() {
	/* 그룹 완료 쪽지 확인 */
	
	
	/* 그룹 강퇴 쪽지 확인 */
})
