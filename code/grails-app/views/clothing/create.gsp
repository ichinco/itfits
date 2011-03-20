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
      brand: <input type="text" name="brand" /><br />
      type: <g:select from="${ClothingType.values()}" name="clothingType" optionValue="displayName" />
      size: <input type="text" name="size" /><br />
      Is it waterproof: <input type="checkbox" name="waterproof" /><br />
      Does it shear: <input type="checkbox" name="shear" /><br />
      <input type="submit" value="Done!" />
    </g:form>
  </body>
</html>