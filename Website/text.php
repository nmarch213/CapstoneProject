<?php
	$subject = '';
	$body = "Here's a link to download our app\n___LINK___";
	$headers = "From IMSportcaster@email.com";
	if($_POST['carrier'] == "ATT"){
		$to = $_POST['number'] . '@txt.att.net';				
	}
	elseif($_POST['carrier'] == "SPT"){
		$to = $_POST['number'] . '@messaging.sprintpcs.com';
	}
	elseif($_POST['carrier'] == "TMB"){
		$to = $_POST['number'] . '@tmomail.net';
	}
	elseif($_POST['carrier'] == "VZN"){
		$to = $_POST['number'] . '@vtext.com';
	}
	else{
		$to = $_POST['number'] . '@gmail.com';
	}
	echo 'Hopefully sent to ' . $to;
	mail( $to, $subject, $body, $headers);
?>
