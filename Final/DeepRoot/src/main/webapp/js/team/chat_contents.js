

// 화면 전환시 채팅 스크롤 최하단으로 위치
$(".chat-element").scrollTop($(".chat-element").height());
$('#chat-textbox-text').each(function() {
    this.contentEditable = true;
});
$('#chat-textbox-text').click(function() {
    $('#chat-textbox-text').focus()
});
$('#chat-textbox-text').keydown(function (e) {
    if ( e.ctrlKey && e.keyCode == 13 ) {
        return
    } else if( e.shiftKey && e.keyCode == 13 ) {
        $('#chat-textbox-text').append('<br>');
        console.log("Input Shift + Enter");
    } else if(e.keyCode == 13) { // Ctrl-Enter pressed
        event.preventDefault();
        $('#chat-textbox-text').html('');
        console.log("Input Enter");
    }
});
