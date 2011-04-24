

<%@ page import="com.itfits.PrivledgeAction" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'privledgeAction.label', default: 'PrivledgeAction')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${privledgeActionInstance}">
            <div class="errors">
                <g:renderErrors bean="${privledgeActionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="action"><g:message code="privledgeAction.action.label" default="Action" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: privledgeActionInstance, field: 'action', 'errors')}">
                                    <g:select name="action" from="${com.itfits.PrivledgeRequiredAction?.values()}" keys="${com.itfits.PrivledgeRequiredAction?.values()*.name()}" value="${privledgeActionInstance?.action?.name()}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="reputation"><g:message code="privledgeAction.reputation.label" default="Reputation" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: privledgeActionInstance, field: 'reputation', 'errors')}">
                                    <g:textField name="reputation" value="${fieldValue(bean: privledgeActionInstance, field: 'reputation')}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
