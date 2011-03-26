<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/11
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <body>
      <g:form controller="user" action="saveMeasurements" method="POST">
          <g:render template="/clothing/measurements" model="[
                'dimensions':dimensions,
                'contribution':contribution
            ]" />
          <g:submitButton name="submit" value="submit" />
      </g:form>
  </body>
</html>