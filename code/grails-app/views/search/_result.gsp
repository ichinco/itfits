<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/20/11
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <body>
    <div class="clothingItem">
        <div class="id">${clothing.id}</div>
        <div class="clothingImage">
            <g:link controller="clothing" action="show"  params="['clothingId':clothing.id]" title="${clothing.brand?.brandName} ${clothing.type?.displayName} ${clothing.style}">
                <g:if test="${clothing.imageUrl}">
                    <img src="${clothing.imageUrl}" alt="${clothing.brand?.brandName} ${clothing.type?.displayName} ${clothing.style}" />
                </g:if>
                <g:else>
                    <img src="${resource(dir:'images',file:'no_image.png',absolute:true)}" alt="${clothing.brand?.brandName} ${clothing.type?.displayName} ${clothing.style}" />
                </g:else>
            </g:link>
        </div>
        <g:each in="${clothing.tags}" var="tag">
            <div class="tag">${tag.tag}</div>
        </g:each>
        <div class="userAction">
            <img class="why" src="${resource(dir:'images', file:'why.png', absolute:tree)}" alt="why?" />
            <img class="delete" src="${resource(dir:'images', file:'delete.png', absolute:tree)}" alt="delete" />
            <div class="not-clothes" url="/code/clothing/notClothes?clothingId=${clothing.id}">not clothes</div>
        </div>
        <div class="explanation">
            <div class="explanation-text">
                Here's where we explain why this showed up in their search.
            </div>
            <div class="closeExplanation">
                <img src="${resource(dir:'images', file:'delete.png', absolute:tree)}" alt="delete" />
            </div>
        </div>
    </div>
  </body>
</html>