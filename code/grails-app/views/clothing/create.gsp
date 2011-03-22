<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/19/11
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.itfits.ClothingType" contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>
    <g:form controller="clothing" action="save" method="POST">
      <input type="hidden" name="clothingId" value="${clothing.id}" />
      brand: <input type="text" name="brand" value="${clothing.brand?.brandName}" /><br />
      type: <g:select from="${ClothingType.values()}" name="clothingType" value="${clothing.type}" optionValue="displayName" />
      size: <input type="text" name="size" value="${clothing.size}"/><br />
      Is it waterproof: <g:checkBox name="waterproof" value="${clothing.isWaterproof}"/><br />
      Does it shear: <g:checkBox name="shear" value="${clothing.isShear}" /><br />
        <div class="measurements">
            <g:each in="${clothing.type?.relevantDimensions ?: ClothingType.values()[0].relevantDimensions}" var="measurementDimension">
                ${measurementDimension.measurementType.displayName}
                <g:textField name="measurement_${measurementDimension.measurementType}" value="${clothing.findMeasurementByType(measurementDimension.measurementType)?.value}" />
                <br />
            </g:each>
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