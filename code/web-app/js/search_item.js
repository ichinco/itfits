/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 5/29/11
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */

$().ready(function(){
    $(".not-clothes").click(function(eventObject){
        $.get($(eventObject.target).attr("url"));
    });
});