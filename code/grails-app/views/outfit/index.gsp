<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 9/5/11
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>Show all outfits</title>
  </head>
  <body>
    <g:each in="${outfits}" var="outfit">
        <g:link controller="outfit" action="view" params="[outfitId:outfit.id]">${outfit.name}</g:link><br />
    </g:each>
  </body>
</html>