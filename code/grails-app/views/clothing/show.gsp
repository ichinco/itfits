<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/19/11
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title>${clothing.brand.brandName} ${clothing.type?.displayName}</title>
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'display.css',absolute:true)}" />
  </head>
  <body>
    <div class="clothingItem">
        <div class="clothingImage">
            <g:link controller="clothing" action="show"  params="['clothingId':clothing.id]">
                <g:if test="${clothing.imageUrl}">
                    <img src="${clothing.imageUrl}" alt="${clothing.brand.brandName} ${clothing.type?.displayName}" />
                </g:if>
                <g:else>
                    <img src="${resource(dir:'images',file:'no_image.png',absolute:true)}" alt="${clothing.brand.brandName} ${clothing.type.displayName}" />
                </g:else>
            </g:link>
        </div>
    </div>

    <div class="info">
        <div class="clothTitle">${clothing.brand.brandName} ${clothing.type?.displayName}</div>
        <g:each in="${clothing.materials}">
            <div class="clothMaterial">${it.name} (${it.percentComposition}&#37;)</div>
        </g:each>
        <g:if test="${clothing.isShear}">
            <div class="shear">is shear</div>
        </g:if>
        <g:if test="${clothing.isWaterproof}">
            <div class="waterproof">is waterproof</div>
        </g:if>
    </div>
  </body>
</html>