<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 4/10/11
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.itfits.ClothingType" contentType="text/html;charset=UTF-8" %>
<html>
  <body>
    <g:form controller="search" action="search">
      <div class="searchContainer">
        <div class="label searchtitle">search</div>
        <input type="submit" class="searchbutton" value="SUBMIT"/>
        <div class="formblock searchradio">
          <input type="radio" name="gender" value="MALE" /><div class="label">male</div>
          <input type="radio" name="gender" value="FEMALE" /><div class="label">female</div>
          <input type="radio" name="gender" value="UNISEX" /><div class="label">unisex</div>
        </div>
        <div class="formblock">
          <div class="label">clothing type</div>
            <select name="clothingType">
                <option>all</option>
                <g:each in="${ClothingType.values()}">
                    <g:if test="${it.isClothing}">
                        <option>${it.displayName}</option>
                    </g:if>
                </g:each>
            </select>
        </div>
        <div class="formblock">
          <div class="label">occasion</div>
            <select name="occasion">
                <option>all</option>
                <g:each in="${occasions}">
                    <option>${it}</option>
                </g:each>
            </select>
        </div>
        <div class="formblock">
          <div class="label">style</div>
            <select name="style">
                <option>all</option>
                <g:each in="${styles}">
                    <option>${it}</option>
                </g:each>
            </select>
        </div>
        <div class="searchAdvancedContainer">
            <div class="formblock">
              <div class="label">price range:</div>
              <select name="price">
                  <option>all</option>
                  <option>Under $25</option>
                  <option>$25 - $50</option>
                  <option>$50 - $75</option>
                  <option>$75 - $100</option>
                  <option>$100 and above</option>
              </select>
              <br />
            </div>
        </div>
      </div>
    </g:form>
  </body>
</html>