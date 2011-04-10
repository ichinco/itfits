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
    <div class="clothingItem">
        <div class="clothingImage">
            <g:link controller="clothing" action="show"  params="['clothingId':clothing.id]">
                <g:if test="${false}">
                    <img src="${clothing.imageUrl}" alt="${clothing.brand.brandName} ${clothing.type.displayName}" />
                </g:if>
                <g:else>
                    <img src="${resource(dir:'images',file:'no_image.png',absolute:true)}" alt="${clothing.brand.brandName} ${clothing.type.displayName}" />
                </g:else>
            </g:link>
        </div>
        <div class="clothSize">We recommend size: ${clothing.size}</div>
        <g:each in="${clothing.tags}" var="tag">
            <div class="tag">${tag.tag}</div>
        </g:each>
    </div>
  </body>
</html>