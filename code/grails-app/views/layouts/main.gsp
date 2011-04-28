<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="silkthread" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <%--<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />--%>
        <g:layoutHead />
        <g:javascript library="jquery" plugin="jquery"/>
    </head>
    <body>
        <!-- logo atop -->
        <div id="topBar">
        <div class="logo"><div class="fore1">silkthread</div>marketplace</div>
        <div id="userBar">
            <g:if test="${user == null}">
                <div class="buttons partiallyOpaque signup">sign up</div>
                <div class="buttons partiallyOpaque login">login</div>
            </g:if>
            <g:else>
                <div class="heading">
                    welcome <div class="buttons">${user.username} </div>
                </div>
            </g:else>
        </div>
        </div>
        <div id="topLine"></div>
        <g:layoutBody />

    </body>
</html>