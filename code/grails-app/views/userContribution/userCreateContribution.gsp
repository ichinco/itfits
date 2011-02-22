<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 2/21/11
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.itfits.MeasurementType" contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Enter measurements</title></head>
  <body>
    <g:form action="find" controller="clothing" method="GET">
        <g:textField name="brand"  />
        <g:textField type="text" name="type"  />
        <g:textField type="text" name="size"  />
    </g:form>
    <g:form action="createContribution" method="POST">
        <g:field type="hidden" name="userId" value="${userId}" />
        <g:checkBox name="isFavorite" />
        <g:each var="measurement" in="${MeasurementType.values()}">
            <g:textField type="text" name="measurement_${measurement.type}" />
            <g:select from="MeasurementDegree" name="degree_${measurement.type}" />
        </g:each>
    </g:form>
  </body>
</html>