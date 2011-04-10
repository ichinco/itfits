$().ready(function(){
    $(".delete").click(function(event){
        var id = $(event.currentTarget).parent().parent().children(".id").text();
        $.get("removeClothing?clothingId=" + id, function(data){
            $(".closet").html(data);
        });
    });
});