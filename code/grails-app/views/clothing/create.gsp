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
      <input type="submit" value="Done!" />
    </g:form>
  </body>
</html>