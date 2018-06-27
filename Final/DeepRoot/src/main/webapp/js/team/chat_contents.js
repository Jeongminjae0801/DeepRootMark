
// 화면 전환시 채팅 스크롤 최하단으로 위치
$(".chat-element").scrollTop($(".chat-element").height());
$('#chat_textbox_text').each(function() {
    this.contentEditable = true;
});
$('#chat_textbox_text').click(function() {
    $('#chat_textbox_text').focus()
});
$('#chat_textbox_text').keydown(function (e) {
    if ( e.ctrlKey && e.keyCode == 13 ) {
        return
    } else if( e.shiftKey && e.keyCode == 13 ) {
        $('#chat_textbox_text').append('<br>');
        console.log("Input Shift + Enter");
    } else if(e.keyCode == 13) { // Ctrl-Enter pressed
        event.preventDefault();
        sendMessage();
        $('#chat_textbox_text').html('');
        console.log("Input Enter");
    }
});
