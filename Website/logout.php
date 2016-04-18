<!DOCTYPE html>
<head>
	<title>Logout Page</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php
	if(!isset($_SESSION)){
		session_start();
	}
	$_SESSION['logged_in'] = false;
?>
<html>
	<body>
		<div class="container" style="margin-top:50px;width:50%; text-align:center;">
			<h1 style="color:red;">SUCCESS BRO!</h1>
			<p>You've been successfully logged out.</p>
			<a href="index.php">Return</a>
		</div>
	</body>	
</html>
