<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/20/11
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Welcome!</title></head>
  <body>
    <g:if test="${action == 'email'}">
      <div>Welcome! A confirmation email is sent to ${emailAddress}.
      To finalize your registration, please click on the link in your email.</div>

      <a href="dashboard">dashboard</a>
    </g:if>
    <g:elseif test="${action == 'debug'}">
      <div>${emailAddress}</div>
      <div>${password}</div>
    </g:elseif>
    <g:else>
      <g:if test="${action == 'error'}">
        <div>${message}</div>
      </g:if>
      <g:form controller="user" action="register" method="POST">
        <input type='text' name='emailAddress' id='email' value="jdoe@email.com"/>
        <input type='password' name='password' id='password' value='abcde' />
        <input type='password' name='passwordConfirm' id='password' value='defgh' />
        <input type='submit' name='submit' value="SUBMIT" />
      </g:form>
    </g:else>
  </body>
</html>