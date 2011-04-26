

<%@ page import="com.itfits.ReputationAction" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'reputationAction.label', default: 'ReputationAction')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${reputationActionInstance}">
            <div class="errors">
                <g:renderErrors bean="${reputationActionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${reputationActionInstance?.id}" />
                <g:hiddenField name="version" value="${reputationActionInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="action"><g:message code="reputationAction.action.label" default="Action" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: reputationActionInstance, field: 'action', 'errors')}">
                                    <g:select name="action" from="${com.itfits.ReputationWorthyAction?.values()}" keys="${com.itfits.ReputationWorthyAction?.values()*.name()}" value="${reputationActionInstance?.action?.name()}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="reputation"><g:message code="reputationAction.reputation.label" default="Reputation" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: reputationActionInstance, field: 'reputation', 'errors')}">
                                    <g:textField name="reputation" value="${fieldValue(bean: reputationActionInstance, field: 'reputation')}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
