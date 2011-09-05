<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 8/7/11
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>Create Outfit</title>
  </head>
  <body>
    <g:form controller="outfit" action="createOutfit" method="POST">
        <input type="hidden" name="userId" value="${user.id}" />
        name: <input type="text" name="name" value="${outfit.name}" /> <br />
        description: <input type="text" name="description" value="${outfit.description}" />  <br />
        tags: <g:textField name="tags" value="${outfit.tags?.collect {it.tag}?.join(' ')}" /> <br />
        <input type="hidden" name="clothingIds" value="outfit.clothes?.collect{it.id}.join(',')" />
        <g:render template="/user/clothBar" model="['clothing':recentlyViewed]" />
        <input type="submit" value="Done!" />
    </g:form>
  </body>
</html>