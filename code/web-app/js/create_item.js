/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 3/21/11
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */

$().ready( function () {
    $("#clothingType").change( function () {
        var model = {};
        model.type = $("#clothingType").attr('value');
        $.post('updateMeasurements', model, function(data){
            $(".measurements").html(data)
        });
    });
});