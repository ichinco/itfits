<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/11
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.itfits.ClothingType" contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
        <body>
            <g:each in="${dimensions}" var="measurementDimension">
                ${measurementDimension.measurementType.displayName}
                <g:textField name="measurement_${measurementDimension.measurementType}" value="${contribution.findMeasurementByType(measurementDimension.measurementType)?.value}" />
                <br />
        </g:each>
  </body>
</html>