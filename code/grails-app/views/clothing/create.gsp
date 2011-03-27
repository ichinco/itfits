<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/19/11
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.itfits.ClothingType" contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="fits_layout" />
  </head>
  <body>
    <g:javascript src="create_item.js" />
    <g:form controller="clothing" action="save" method="POST">
        <input type="hidden" name="clothingId" value="${clothing.id}" />
        <input type="hidden" name="userId" value="${user.id}" />
        brand: <input type="text" id="brand" name="brand" autocomplete="off" value="${clothing.brand?.brandName}" /><br />
        <div id="brandSuggestion"><span>blah</span></div>
        type: <g:select from="${ClothingType.values()}" id="clothingType" name="clothingType" value="${clothing.type}" optionValue="displayName" />
        size: <input type="text" name="size" value="${clothing.size}"/><br />
        Is it waterproof: <g:checkBox name="waterproof" value="${clothing.isWaterproof}"/><br />
        Does it shear: <g:checkBox name="shear" value="${clothing.isShear}" /><br />
        <div class="measurements">
            <g:render template="measurements" model="[
            'dimensions':clothing.type?.relevantDimensions ?: ClothingType.values()[0].relevantDimensions,
            'contribution':contribution
            ]" />
        </div>
        <div class="materials">
            <g:each in="${clothing.materials}" var="material" status="i">
                material type: <input type="text" name="materialType${i}" value="${material.name}" />
                composition: <input type="text" name="materialComposition${i}" value="${material.percentComposition}" />
                <br />
            </g:each>
        </div>
        review: <br/> <g:textArea name="review" rows="6" cols="56" /> <br />
        tags: <g:textField name="tags" value="${clothing.tags?.collect {it.tag}?.join(' ')}" /> <br />
        <input type="submit" value="Done!" />
    </g:form>
  </body>
</html>