<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="silkthread" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <%--<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />--%>
        <g:layoutHead />
        <g:javascript library="jquery" plugin="jquery" />
        <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'autocomplete.css',absolute:true)}" />
        <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'navigation.css',absolute:true)}" />
    </head>
    <body>
        <!-- logo atop -->
        <div id="topBar">
        <div class="logo"><div class="fore1">silkthread</div>marketplace</div>
        <div id="userBar">
            <g:if test="${user == null}">
                <div class="buttons partiallyOpaque signup">sign up</div>
                <g:link controller="login" action="auth">
                    <div class="buttons partiallyOpaque login">login</div>
                </g:link>
            </g:if>
            <g:else>
                <div class="heading">
                    welcome
                    <g:link controller="user" action="dashboard">
                        <div class="buttons partiallyOpaque signup" style="margin-right:-4px;">${user.username}</div>
                    </g:link>
                    <g:link controller="logout"><div class="buttons partiallyOpaque login">logout</div></g:link>
                </div>
            </g:else>
        </div>
        </div>
        <div id="topLine"></div>
        <div class="sidebar">
            <div class="sidebarIcon selected">
                <img class="sidebarIcon" src="${resource(dir:'images', file: "blueflower.png")}" /><br />
                my wardrobe
            </div>
            <div class="sidebarIcon">
                <g:link controller="user" action="edit" params="[id:user.id]">
                    <img class="sidebarIcon" src="${resource(dir:'images', file:'butterfly.png')}" /><br />
                    me</g:link>
            </div>
            <div class="sidebarIcon" >
              <g:link controller="search">Search</g:link> <br />
            </div>
        </div>

        <g:layoutBody />
    </body>
</html>