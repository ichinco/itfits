<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 3/19/11
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main" />
      <title>${clothing.brand?.brandName} ${clothing.type?.displayName} ${clothing.style}</title>
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'display.css',absolute:true)}" />
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'voting.css',absolute:true)}" />
      <g:javascript src="voting.js"/>
  </head>
  <body>
    <div class="clothingItem">
        <div class="clothingImage">
            <g:link controller="clothing" action="show"  params="['clothingId':clothing.id]">
                <g:if test="${clothing.imageUrl}">
                    <img src="${clothing.imageUrl}" alt="${clothing.brand?.brandName} ${clothing.type?.displayName} ${clothing.style}" />
                </g:if>
                <g:else>
                    <img src="${resource(dir:'images',file:'no_image.png',absolute:true)}" alt="${clothing.brand?.brandName} ${clothing.type?.displayName} ${clothing.style}" />
                </g:else>
            </g:link>
        </div>
    </div>

    <div class="info">
        <div class="clothTitle">${clothing.brand?.brandName} ${clothing.type?.displayName} ${clothing.style}</div>
        <g:each in="${clothing.materials}">
            <div class="clothMaterial">${it.name} (${it.percentComposition}&#37;)</div>
        </g:each>
        <g:if test="${clothing.isShear}">
            <div class="shear">is shear</div>
        </g:if>
        <g:if test="${clothing.isWaterproof}">
            <div class="waterproof">is waterproof</div>
        </g:if>
    </div>

  <iframe src="http://www.facebook.com/plugins/like.php?href=${request.scheme + "://" + request.serverName + request.forwardURI}"
          scrolling="no" frameborder="0"
          style="border:none; width:450px; height:80px">
  </iframe>

  <div class="categories">
        <g:render template="/voting/vote" model="['elements' : occasions, 'type':'occasion', 'title':'I\'d wear this to...', 'clothingId':clothing.id]" />
        <br />
        <g:render template="/voting/vote" model="['elements' : styles, 'type':'style', 'title':'The style is:', 'clothingId': clothing.id]"/>
  </div>
  
  <div>
      <g:each in="${clothing.reviews}" var="review">
          <div class="reviewUser">${review.user.username}</div>
          <div class="reviewRepuation">${review.user.reputation}</div>
          <div class="reviewDate">${review.dateCreated}</div>
          <br />
          <div class="reviewText">${review.text}</div>
      </g:each>
      <g:if test="${request.signedIn}">
          <g:textArea id="userReview" name="userReview" rows="5" cols="50"/>
          <br />
          <g:submitButton id="submitReview" name="submitReview" value="submit" url="/code/review/submit" clothingId="${clothing.id}" />
      </g:if>
  </div>

  </body>
</html>