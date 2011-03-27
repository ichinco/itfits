/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 3/21/11
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */

$().ready( function () {
    $("#brandSuggestion").css("visibility", "hidden");
    $("#clothingType").change( function () {
        var model = {};
        model.type = $("#clothingType").attr('value');
        $.post('../clothing/updateMeasurements', model, function(data){
            $(".measurements").html(data);
        });
    });

    $("#brand").keypress( function (eventObject) {
        if (eventObject.which != 0){
            var model = {};
            model.brandName = $("#brand").attr('value') + alphaNumericCheck(eventObject.which) + "";
            $.post('../brand/find', model, function(data){
                if (data.length == 0 || $("#brand").attr('value') == ''){
                    $("#brandSuggestion").css("visibility", "hidden");
                } else {
                    $("#brandSuggestion").css("visibility","visible");
                    $("#brandSuggestion").empty();
                    $.each(data,function(){
                        $("#brandSuggestion").append("<div>"+ this +"</div><br />");
                    });
                }
            });
        } else {
            var currentlySelected = $("#brandSuggestion").children('.selected');
            $(currentlySelected).removeClass('selected');
            $(currentlySelected).addClass('unselected');
            switch (eventObject.keyCode){
                case 38:
                    currentlySelected.previous().removeClass('unselected');
                    currentlySelected.previous().addClass('selected');
                    break;
                case 40:
                    var next;
                    if (currentlySelected.length == 0) {
                        next = $("#brandSuggestion").children().first();
                    } else {
                        next = currentlySelected.next();
                    }
                    next.addClass('selected');
                    next.removeClass('unselected');
                    break;
                case 9:
                    $('#brand').attr('value', currentlySelected.text());
                    break;
            }
        }
    });
});
function alphaNumericCheck(theChar) {

	if ((theChar < 48) || (theChar > 122) ||
	   ((theChar > 57) && (theChar < 65)) ||
	   ((theChar > 90) && (theChar < 97))   ) {
		return "";
	} else {
		return String.fromCharCode(theChar);
	}
}

