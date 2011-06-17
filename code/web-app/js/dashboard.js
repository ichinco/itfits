$().ready(function(){
    $(".delete").click(function(event){
        var id = $(event.currentTarget).parent().parent().children(".id").text();
        $.get("removeClothing?clothingId=" + id, function(data){
            $(".container").html(data);
        });

    });

        $("html").css("height", String($(".container").offset().top +
                $(".container").height() + 30)+"px");
});