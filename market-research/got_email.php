<?php
	$link = mysql_connect('evilwire.fatcowmysql.com', 'evilwire_app', '$u13pol0nium'); 
	if (!$link) { 
	    die('Could not connect: ' . mysql_error());
	}
	
	mysql_select_db(evilwire_IC_20100113_123836);
	
	$email = $_GET["email"];
	$product = $_GET["site"];
	
	$sql = sprintf("INSERT INTO market_research (email,product) VALUES ('%s','%s')", mysql_real_escape_string($email), mysql_real_escape_string($site));
	$result = mysql_query($sql);

	header( 'Location: $_GET["thanks"] ) ;
?>