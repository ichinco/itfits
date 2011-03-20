<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/19/11
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>${clothing.brand.brandName} ${clothing.type.displayName} ${clothing.size}</title></head>
  <body>
    <div class="clothTitle">${clothing.brand.brandName} ${clothing.type.displayName}</div>
    <div class="clothSize">${clothing.size}</div>
    <g:each in="${clothing.materials}">
        <div class="clothMaterial">${it.name} (${it.percentComposition}&#37;)</div>
    </g:each>
    <g:if test="${clothing.isShear}">
        <div class="shear">is shear</div>
    </g:if>
    <g:if test="${clothing.isWaterproof}">
        <div class="waterproof">is waterproof</div>
    </g:if>
  </body>
</html>