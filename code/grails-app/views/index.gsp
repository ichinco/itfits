<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <g:javascript library="jquery" plugin="jquery"/>
  <link rel="stylesheet" href="${resource(dir:'css', file:'main.css')}">
  <script type="text/javascript">
      $(document).ready(
          function()
          {
          });
  </script>
  <body>
    <div class="gradient"></div>
    <div class="titleBar shadow">
        <div class="titleLogo">itfits</div>
        <div class="titleItem"><g:link controller="user" action="register">register</g:link></div>
        <div class="titleItem"><g:link controller="login" action="auth">login</g:link></div>
        <div class="titleItem"><g:link controller="logout">logout</g:link></div>
        <div class="titleItem"><g:link controller="search">search</g:link></div>
        <div class="titleItem"><g:link controller="user" action="dashboard">dashboard</g:link></div>
    </div>
  </body>
</html>