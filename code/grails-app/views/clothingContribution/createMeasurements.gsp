<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 8/27/11
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.itfits.ClothingType" contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
   <body>
    <g:form controller="clothingContribution" action="addMeasurements" method="POST">
        <g:hiddenField name="clothingId" value="${clothing.id}" />
        <g:hiddenField name="userId" value="${user.id}" />
        <div class="measurements">
            <g:render template="/clothing/measurements" model="[
            'dimensions':clothing.type?.relevantDimensions ?: ClothingType.values()[0].relevantDimensions,
            'contribution':contribution
            ]" />
        </div>

        <input type="submit" value="Done!" />
    </g:form>
  </body>
</html>