<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/11
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title><g:layoutTitle default="fits"/></title>
      <g:javascript library="jquery" plugin="jquery"/>
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'autocomplete.css',absolute:true)}" />
      <g:layoutHead />
  </head>
  <body>
      <div id="userInfo">${user?.username} ${user?.reputation ?: 0}</div>
      <g:layoutBody />
  </body>
</html>