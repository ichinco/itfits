<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/20/11
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Welcome</title></head>
  <body>
    <div>Logged in: ${user.username}</div>
    <div><a href="/code/user/edit?id=${user.id}">edit</a></div>
    <div><a href="/code/clothing/create?id=${user.id}">create clothing</a></div>
                <!-- [sounding like an ass:], passing id's is not necessary.
                Blah blah blah, allow me to edit the clothing page so that
                we don't need this part. [End of talking] -->
    <g:link controller="search">Search</g:link> <br />
  </body>
</html>
