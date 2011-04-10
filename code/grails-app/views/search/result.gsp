<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/20/11
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="fits_layout" />
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'search.css',absolute:true)}" />
      <g:javascript src="searchui.js" />
      <link rel="stylesheet" href="${resource(dir:'css', file:'searchUI.css')}" />
      <link rel="stylesheet" href="${resource(dir:'css', file:'forms.css')}" />
  </head>
  <body>
    <g:render template="searchUI" />
    <g:each in="${clothes}" var="clothing">
        <g:render template="result" model="['clothing':clothing]" />
    </g:each>
  </body>
</html>