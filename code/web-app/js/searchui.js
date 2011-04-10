$().ready( function() {
    $(".userAction").click(function(event){
        $(event.currentTarget).next(".explanation").css("display","block");
    });
    $(".closeExplanation").click(function(event){
        $(event.currentTarget).parent().css("display","none");
    });
});

function SUI_format(JSONFormatter)
{
    // turn all the color-swatches to their colors
    $(".searchSwatch").each(function(index)
        {
            $(this).css("background-color", $(this).html());
            $(this).html("");
        });
}

