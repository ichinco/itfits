<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 8/7/11
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>Add to an outfit</title>
  </head>
  <body>
    <g:each in="${user.outfits}" var="outfit">
        <g:link controller="outfit" action="changeOutfit" params="[outfitId:outfit.id, clothing:outfit.cloths.collect({it.id}).plus([item.id]).join(',')]">${outfit.name}</g:link> <br />
    </g:each>
    <g:link controller="outfit" action="create" params="[clothing:item.id]">Create Outfit</g:link>
  </body>
</html>