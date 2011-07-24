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
                    <g:link controller="user" action="dashboard">
                        <div class="buttons partiallyOpaque signup" style="margin-right:-4px;">${user.username}</div>
                    </g:link>
                     <g:link controller="user" action="edit" params="[id:user.id]"><div class="buttons partiallyOpaque settings">settings</div></g:link>
                    <g:link controller="logout"><div class="buttons partiallyOpaque login">logout</div></g:link>
                </div>
            </g:else>
        </div>
        </div>
        <div id="topLine"></div>
        <div class="sidebar">
            <div class="sidebarIcon ${ params.controller == 'user' && params.action == 'dashboard' ? 'selected' : ''}">
                <g:link controller="user" action="dashboard">Me</g:link> <br />
            </div>
            <div class="sidebarIcon ${ params.controller == 'search' ? 'selected' : ''}" >
              <g:link controller="search">Search</g:link> <br />
            </div>
            <div class="sidebarIcon ${ params.controller == 'outfit' ? 'selected' : ''}" >
              <g:link controller="outfits">outfits</g:link> <br />
            </div>
        </div>

        <g:layoutBody />
    </body>
</html>