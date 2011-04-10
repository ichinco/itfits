function SUI_format(JSONFormatter)
{
    // turn all the color-swatches to their colors
    $(".searchSwatch").each(function(index)
        {
            $(this).css("background-color", $(this).html());
            $(this).html("");
        });
}