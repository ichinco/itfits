<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/20/11
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/20/11
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>
  <div>${usercount}</div>
  <g:if test="${usercount > 0}">
    <g:each in="${users}">
        <div>${it.emailAddress}</div>
    </g:each>
  </g:if>
  <g:else>
    <div>${usercount}</div>
    <div>no users</div>
  </g:else>
  </body>
</html>