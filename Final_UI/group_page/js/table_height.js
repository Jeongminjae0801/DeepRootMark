
$(function() {
    var window_height = $(window).height();
    var window_width = $(window).width();
    
    $('#main-row').height(window_height + "px");
    $('#main-row').width(window_width + "px");
    
    $(window).resize(function() {
        window_height = $(window).height();
        window_width = $(window).width();
        
        $('#main-row').height((window_height*0.8) + "px");
        $('#main-row').width((window_width*0.8) + "px");
    });
    
});