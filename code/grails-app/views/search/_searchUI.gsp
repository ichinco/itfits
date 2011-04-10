<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 4/10/11
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <link rel="stylesheet" href="${resource(dir:'css', file:'searchUI.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css', file:'forms.css')}" />

    <title>Simple GSP page</title>
  </head>
  <body>
    <g:form action="POST" name="search">
      <div class="searchContainer">
        <div class="label searchtitle">search</div>
        <input type="submit" class="searchbutton" value="SUBMIT"/>
        <div class="formblock searchradio">
          <input type="radio" name="gender" value="MALE" /><div class="label">male</div>
          <input type="radio" name="gender" value="FEMALE" /><div class="label">female</div>
          <input type="radio" name="gender" value="UNISEX" /><div class="label">unisex</div>
        </div>
        <div class="formblock">
          <div class="label">clothing type</div>
          <input name="clothingType:" value="jeans" />
        </div>
        <div class="formblock">
          <div class="label">brand:</div>
          <select name="brand">
            <option>automatically</option>
            <option>generated</option>
            <option>via</option>
            <option>GSP</option>
          </select>
        </div>
        <div class="searchExpander">advanced <div class="searchGraphic">+</div></div>
      </div>
    </g:form>
  </body>
</html>