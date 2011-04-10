<%--
  Created by IntelliJ IDEA.
  User: glassfin
  Date: 4/10/11
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <link rel="stylesheet" href="${resource(dir:'css', file:'searchUI.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css', file:'forms.css')}" />
    <title>Simple GSP page</title>
    <g:javascript library="jquery" plugin="jquery"/>
    <!-- YUI internet sources -->
    <!-- Dependencies -->
    <script src="http://yui.yahooapis.com/2.8.2r1/build/utilities/utilities.js" type="text/javascript"></script>
    <script src="http://yui.yahooapis.com/2.8.2r1/build/slider/slider-min.js" type="text/javascript"></script>

    <!-- Color Picker source files for CSS and JavaScript -->
    <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.8.2r1/build/colorpicker/assets/skins/sam/colorpicker.css">
    <script src="http://yui.yahooapis.com/2.8.2r1/build/colorpicker/colorpicker-min.js" type="text/javascript"></script>

    <script type="text/javascript" charset="UTF-8" src="${resource(dir:'js', file:"searchui.js")}"></script>
    <script type="text/javascript">
        function searchUI_init()
        {
          SUI_format();
          /*
          var picker = new YAHOO.widget.ColorPicker("colorpicker",
            {
              showhsvcontrols: false,
              showhexcontrols: false,
              images: {
                PICKER_THUMB: "picker_thumb.png",
                HUE_THUMB: "hue_thumb.png"
              }
            });

          alert($("#colorpicker").css("position", "absolute"));
          */
        }
        $(document).ready(searchUI_init);
    </script>
  </head>
  <body>
    <g:form action="POST" name="search">
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
          <input name="clothingType:" value="jeans" />
        </div>
        <div class="formblock">
          <div class="label">brand:</div>
          <select name="brand">
            <option>automatically</option>
            <option>generated</option>
            <option>via</option>
            <option>GSP</option>
          </select>
        </div>
        <div class="searchExpander">advanced <div class="searchGraphic">+</div></div>
        <div class="searchAdvancedContainer">
              <div class="label searchsubtitle">size</div>
              <div class="formblock">
                <input type="checkbox" name="size" value="XS" /><div class="label">XS</div>
                <input type="checkbox" name="size" value="S" /><div class="label">S</div>
                <input type="checkbox" name="size" value="M" /><div class="label">M</div>
                <input type="checkbox" name="size" value="L" /><div class="label">L</div>
                <input type="checkbox" name="size" value="XL" /><div class="label">XL</div>
              </div>
            <div class="searchExpander">enter measurements <div class="searchGraphic">+</div></div>
            <br />
            <div class="label searchsubtitle">color</div>
            <div class="formblock">
                <input type="checkbox" name="color" /><div class="searchSwatch">white</div>
                <input type="checkbox" name="color" /><div class="searchSwatch">black</div>
                <input type="checkbox" name="color" /><div class="searchSwatch">red</div>
                <input type="checkbox" name="color" /><div class="searchSwatch">green</div>
                <input type="checkbox" name="color" /><div class="searchSwatch">blue</div>
            </div>
            <div class="searchExpander">more colors and schemes <div class="searchGraphic">+</div></div>
            <br />
            <div class="label searchsubtitle">review</div>
            <div class="formblock">
              <select name="brand">
                  <option>0</option>
                  <option>1</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option>
                  <option>5</option>
              </select>
              <div class="label">stars and up</div>
            </div>
            <br />
            <div class="label searchsubtitle">price</div>
            <div class="formblock">
              <div class="label">price range:</div>
              <select name="brand">
                  <option>Under $25</option>
                  <option>$25 - $50</option>
                  <option>$50 - $75</option>
                  <option>$75 - $100</option>
                  <option>$100 and above</option>
                  <option>Custom</option>
              </select>
              <br />
              <div class="formblock">
                <div class="label">from $</div><input class="priceInput" name="custPriceLower" />
                <div class="label"> to $</div><input class="priceInput" name="custPriceHigher" />
              </div>
            </div>
            <div class="formblock">
              <input type="checkbox" name="isAvailToBuy"/><div class="label">available for purchase</div>
            </div>
            <div class="formblock">
                <div class="searchExpander"> materials <div class="searchGraphic">+</div></div>
            </div>
            <div class="formblock">
                <div class="searchExpander"> discounts <div class="searchGraphic">+</div></div>
            </div>
        </div>
      </div>
    </g:form>
  </body>
</html>