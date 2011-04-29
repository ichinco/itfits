<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title>Welcome to SilkThread</title>
      <meta name="layout" content="main" />

  <style type="text/css">
    .mainContent
    {
        padding-bottom: 200px;
        width: 800px;
        display: inline;
    }

    .wrapper
    {
        min-height: 100%;
        position: relative;
        text-align: center;
    }

    #footer
    {
        position: absolute;
        bottom: 0%;
        color: #fff;
        font-size: 25px;

        height: 200px;
        width: 100%;
        text-align: center;
    }

    .wrap
    {
        display: inline-table;
        width: 800px;

        overflow: hidden;
        text-align: left;
    }

    #regbar
    {
        width: 100%;
        height: 80px;
        background-color: RGB(75, 150, 170);
    }

    .column
    {
        text-align: left;
        display: table-cell;
        font-size: 10px;
        padding-top: 10px;
        padding-left: 10px;
        padding-right: 10px;
        width: 80px;

        font-family: verdana;

        opacity: .5;
        -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";
        filter: alpha(opacity=50);

        cursor: default;
    }

    .column:hover
    {
        opacity: 1;
        -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
        filter: alpha(opacity=100);
    }

    .info
    {
        color: #cff;
    }

    </style>
  </head>
  <g:javascript library="jquery" plugin="jquery"/>
  <link rel="stylesheet" href="${resource(dir:'css', file:'main.css')}">
  <script type="text/javascript">
      $(document).ready(
          function()
          {
          });
  </script>
  <body>
    <!--
    <div class="titleBar shadow">
        <div class="titleLogo">itfits</div>
        <div class="titleItem"><g:link controller="user" action="register">register</g:link></div>
        <div class="titleItem"><g:link controller="login" action="auth">login</g:link></div>
        <div class="titleItem"><g:link controller="logout">logout</g:link></div>
        <div class="titleItem"><g:link controller="search">search</g:link></div>
        <div class="titleItem"><g:link controller="user" action="dashboard">dashboard</g:link></div>
    </div>-->
    <div class="wrapper">
        <div class="mainContent">hello</div>
    </div>

    <div id="footer">
        <div id="regbar">

        </div>
        <div class="wrap">
            <div class="column">
                <div class="bold medium" style="margin-bottom: 10px;">Account</div>
                sign up <br />
                dashboard <br />
                settings <br />
                badges <br />
                notifications
            </div>
            <div class="column">
                <div class="bold medium" style="margin-bottom: 10px;">About Us</div>
                company <br />
                press release <br />
                careers <br />
                blog
            </div>
            <div class="column">
                <div class="bold medium" style="margin-bottom: 10px;">Help</div>
                support <br />
                site map <br />
                style glossary <br />
                recommendations <br />
                entering measurements
            </div>
            <div class="column">
                <div class="bold medium" style="margin-bottom: 10px;">More</div>
                downloads <br />
                66now (design studio) <br />
                fashion news <br />
                bloggosphere
            </div>
            <div class="column info" style="text-align: right; width: 150px;">
                Support: 1-800-228-2839<br />
                (c) 2011-2012 silkthread.com <br />
                All Rights Reserved <br />
                Privacy Policy | Legal Notices <br />
                Powered by Tomcat
            </div>
        </div>
    </div>
  </body>
</html>