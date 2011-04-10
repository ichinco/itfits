<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 4/10/11
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <body>
    <g:each in="${contributions}" var="contribution">
        <g:render template="/search/result" model="['clothing':contribution.clothing]" />
    </g:each>
  </body>
</html>