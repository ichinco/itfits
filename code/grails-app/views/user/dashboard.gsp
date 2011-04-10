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
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'dashboard.css',absolute:true)}" />
  </head>
  <body>
    <div>Logged in: ${user.username}</div>
    <div>
        <g:link controller="user" action="edit" params="[id:user.id]">edit</g:link>
    </div>
    <div>
        <g:link controller="clothing" action="create" params="[id:user.id">create clothing</g:link>
    </div>
                <!-- [sounding like an ass:], passing id's is not necessary.
                Blah blah blah, allow me to edit the clothing page so that
                we don't need this part. [End of talking] -->
    <div>
      <g:link controller="search">Search</g:link> <br />
    </div>
    <div>
        <g:each in="${user.contributions}" var="contribution">
            <g:render template="/search/result" model="['clothing':contribution.clothing]" />
        </g:each>
    </div>
  </body>
</html>
