/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 7/24/11
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */

$(button).click(function(event){
    $("document").click(grab);
});

var grab = function(event){
    $("document").unbind("click", grab);
}