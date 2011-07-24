$().ready( function() {
    $(".why").click(function(event){
        $(event.currentTarget).parent().next(".explanation").css("display","block");
    });
    $(".closeExplanation").click(function(event){
        $(event.currentTarget).parent().css("display","none");
    });
});

function SUI_format()
{
    // turn all the color-swatches to their colors
    $(".searchSwatch").each(function(index)
        {
            $(this).css("background-color", $(this).html());
            $(this).html("");
        });
}

