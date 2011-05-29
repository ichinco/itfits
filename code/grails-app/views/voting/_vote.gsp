<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 5/29/11
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <div>
        <div class="title">${title}</div>
        <div class="elementType">${type}</div>
        <div class="clothingId">${clothingId}</div>
        <g:each in="${elements}" var="element">
            <%
                def voteClass = "votingElement"
                voteClass = element.upvoted ? "votingUpvoted" : voteClass
                voteClass = element.downvoted ? "votingDownvoted" : voteClass

                def record = element.record
            %>
            <div class="votes">${element.record.upvotes} | ${element.record.downvotes}</div>
            <div class="${voteClass}" id="${record.id}"> ${record.type.name} </div>
            <br />
        </g:each>
        <g:textField name="voteOther" class="voteOther" value=""/>
    </div>
</html>