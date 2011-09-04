<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 8/7/11
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>View outfit</title>
  </head>
  <body>
    ${outfit.name} <br />
    ${outfit.description} <br />

    <div>
        <g:each in="${outfit.cloths}" var="clothing">
            <img src="${clothing.imageUrl}" alt="${clothing.brand} ${clothing.type}" />
        </g:each>
    </div>
  </body>
</html>