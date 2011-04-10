$().ready( function() {
    $(".userAction").click(function(event){
        $(event.currentTarget).next(".explanation").css("display","block");
    });
    $(".closeExplanation").click(function(event){
        $(event.currentTarget).parent().css("display","none");
    });
});