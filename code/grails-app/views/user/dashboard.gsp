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
    <g:render template="clothBar" model="['clothing':likedItems]" />
  </body>
</html>
