<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 7/23/11
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <body>
    <div><</div>
    <div>
        <g:each var="item" in="${clothing}">
            <img src="${item.imageUrl}" alt="${item.brand} ${item.style}" />
        </g:each>
    </div>
    <div>></div>
  </body>
</html>