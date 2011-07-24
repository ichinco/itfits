<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/20/11
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'search.css',absolute:true)}" />
    <g:javascript src="searchui.js" />
    <link rel="stylesheet" href="${resource(dir:'css', file:'searchUI.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css', file:'forms.css')}" />

    <!-- YUI internet sources -->
    <!-- Dependencies -->
    <script src="http://yui.yahooapis.com/2.8.2r1/build/utilities/utilities.js" type="text/javascript"></script>
    <script src="http://yui.yahooapis.com/2.8.2r1/build/slider/slider-min.js" type="text/javascript"></script>

    <!-- Color Picker source files for CSS and JavaScript -->
    <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.8.2r1/build/colorpicker/assets/skins/sam/colorpicker.css">
    <script src="http://yui.yahooapis.com/2.8.2r1/build/colorpicker/colorpicker-min.js" type="text/javascript"></script>

    <script type="text/javascript" charset="UTF-8" src="${resource(dir:'js', file:"searchui.js")}"></script>
    <script type="text/javascript" charset="UTF-8" src="${resource(dir:'js', file:"search_item.js")}"></script>
    <script type="text/javascript">
        function searchUI_init()
        {
          SUI_format();
        }
        $(document).ready(searchUI_init);
    </script>
  </head>
  <body>
    <div class="search_navigation">
        <g:render template="searchUI" />
    </div>
    <div class="results">
        <g:each in="${clothes}" var="clothing">
            <g:render template="result" model="['clothing':clothing]" />
        </g:each>
    </div>
  </body>
</html>