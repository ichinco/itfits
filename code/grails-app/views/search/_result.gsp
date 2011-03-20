<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/20/11
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>
    <div class="clothTitle">${clothing.brand.brandName} ${clothing.type.displayName}</div>
    <div class="clothSize">${clothing.size}</div>
    <g:each in="${clothing.materials}">
        <div class="clothMaterial">${it.name} (${it.percentComposition}&#37;)</div>
    </g:each>
  </body>
</html>