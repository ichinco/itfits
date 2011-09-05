<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 8/7/11
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <body>
    <g:each in="${outfits}" var="outfit">
        <g:link controller="outfit" action="view" params="[outfitId:outfit.id]">${outfit.name}</g:link>
        <g:link controller="outfit" action="create" params="[outfitId:outfit.id]">edit</g:link>
        <g:link controller="outfit" action="deleteOutfit" params="[outfitId:outfit.id, userId:user.id]">delete</g:link>
        <br />
    </g:each>
    <g:link controller="outfit" action="create">Create new Outfit</g:link>
  </body>
</html>