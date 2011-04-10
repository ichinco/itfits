<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/20/11
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>
    <g:render template="searchUI" />
    <g:each in="${clothes}" var="clothing">
        <g:render template="result" model="['clothing':clothing]" /><br /><br />
    </g:each>
  </body>
</html>