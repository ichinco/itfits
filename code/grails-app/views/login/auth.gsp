<head>
<%--<meta name='layout' content='main' /> --%>
<title>Login</title>

<link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
<style type='text/css'>

#login
{
    display: table;
    text-align: center;
}

.inner
{
    display: table-cell;
    vertical-align: middle;
    width: 400px;
    text-align: center;
}

.content
{
    display: inline-block;
    text-align: left;
    color: #aaa;
}

#login	{
    /* for the naive script-less souls*/
    margin-top: 20%;

    display:table; /*position:static;*/
    height: 40%;
    width: 100%
}

.inner	{
    display:table-cell;
    vertical-align:middle;
    /*position:static;*/

    /* IE solution */
}

.text_
{
    height: 45px;
    width: 250px;
    font-size: 28px;
    font-family: Times New Roman;
    background-color: #ccc;

    border: #469 solid 2px;
    padding-left: 10px;
    padding-right: 10px;

    border-radius: 10px;
    -moz-border-radius: 10px;

    background: -moz-linear-gradient(top, #fff, #abc);
    background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#abc));

}

.text_:focus
{
    background-color: #fff;
}

.authsubmit
{
    font-size: 30px;
    font-family: Times New Roman;
    border: 0px;
    color: white;
}
</style>
</head>
<g:javascript library="jquery" plugin="jquery"/>
<body>
	<div id='login'>
		<div class='inner'>
            <g:if test='${flash.message}'>
                <div class='login_message'>${flash.message}</div>
                </g:if>
            <div class="content">

			    <div class='fheader'>LOGO</div>
                <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                    <p>
                        <input type='text' class='text_' name='j_username' id='username' /><br />
                        <label for='username'>email</label>
                    </p>
                    <p>
                        <input type='password' class='text_' name='j_password' id='password' /><br />
                        <label for='password'>password</label>
                    </p>
                    <p>
                        <label for='remember_me'>Remember me</label>
                        <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me'
                        <g:if test='${hasCookie}'>checked='checked'</g:if> />
                    </p>
                    <p>
                        <input type='submit' class="buttons authsubmit" value='login' />
                    </p>
                </form>
            </div>
		</div>
	</div>
<script type='text/javascript'>
<!--
function _main()
{
    // format IE 5+
    if(document.attachEvent)
    {
        $('#login').css({"float": "left",
                         "height": "50%",
                         "margin-bottom": "-200px;"});

        $('#login > .inner').css({
            "clear": "both",
            "height": "400px",
            "position": "relative"
        });
    }

    $('#username').focus();
}
$(document).ready(_main);

// -->
</script>
</body>
