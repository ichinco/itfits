/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 5/29/11
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */

$().ready( function() {
    $(".votingElement").click(function(eventObject){
        var target=$(eventObject.target);
        vote(target.id, getElementType(target.parent()), getClothingId(target.parent()));
    });

    $(".voteOther").keypress(function(eventObject){
        var target=$(eventObject.target);
        if (eventObject.keyCode == 13){
            vote(target.val(), getElementType(target), getClothingId(target));
        }
    });

    $("#submitReview").click(function(eventObject){
        var text = $("#userReview").val();
        var params = {};
        params.clothingId = $(eventObject.target).attr("clothingId");
        params.reviewText = text;
        $.post($(eventObject.target).attr("url"), params);
    });
});

var getClothingId = function(target){
    return target.parent().children(".clothingId").html();
};

var getElementType = function(target){
    return target.parent().children(".elementType").html();
};

var vote = function(id, type, clothing){
    var model = {};
    model.elementId=id;
    model.type=type;
    model.clothing=clothing;
    $.post('/code/voting/cast', model, function(data){

    });
};