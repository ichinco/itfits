
<%@ page import="com.itfits.PrivledgeAction" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'privledgeAction.label', default: 'PrivledgeAction')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'privledgeAction.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="action" title="${message(code: 'privledgeAction.action.label', default: 'Action')}" />
                        
                            <g:sortableColumn property="reputation" title="${message(code: 'privledgeAction.reputation.label', default: 'Reputation')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${privledgeActionInstanceList}" status="i" var="privledgeActionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${privledgeActionInstance.id}">${fieldValue(bean: privledgeActionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: privledgeActionInstance, field: "action")}</td>
                        
                            <td>${fieldValue(bean: privledgeActionInstance, field: "reputation")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${privledgeActionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
