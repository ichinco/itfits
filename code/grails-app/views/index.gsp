<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>
        <g:link controller="user" action="register">Register</g:link> <br />
        <g:link controller="login" action="auth">Login</g:link> <br />
        <g:link controller="logout">Logout</g:link> <br />
        <g:link controller="search">Search</g:link> <br />
        <g:link controller="user" action="dashboard">Dashboard</g:link> <br />
  </body>
</html>