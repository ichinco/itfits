<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/20/11
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'dashboard.css',absolute:true)}" />
      <g:javascript library="jquery" plugin="jquery"/>
      <g:javascript src="dashboard.js" />
  </head>
  <body>
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

    <div class="container">
        <g:link controller="clothing" action="create" params="[id:user.id]">add cloth</g:link>
        <g:render template="clothingList" model="['contributions':user.contributions]" />
    </div>
  </body>
</html>
