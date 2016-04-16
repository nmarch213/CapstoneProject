<!DOCTYPE html>
<head>
	<title>Login Page</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php
	$email = $_POST['login_email'];
	$password = $_POST['login_pass'];
	include 'database_info.php';
	$collection = $dbname->selectCollection('users');
	$result = $collection->findOne(array('email' => $email));
	$passCheck = ($result['password']);
	$isPassCorrect = password_verify($password, $passCheck);
	session_start();
	if($result!=null && $isPassCorrect)	{
		$_SESSION["logged_in"] = true;
		$_SESSION["official"] = $result['official_user'];
		$heading = "SUCCESS BRO!";
		$display = "Thank you for logging in " . $result['firstName'] . " " . $result['lastName'] . "!";
		$href = "index.php";
	}
	else	{
		$heading = "Failure Bro!";
		$emailCheck = $collection->findOne(array('email' => $email));
		if($emailCheck!=null)	{
			$display = "Incorrect password!";
		}
		else	{
			$display = "Error, no such user found.";
		}
		$href = "login.html";
	}	
?>
<html>
	<body>
		<div class="container" style="margin-top:50px;width:50%; text-align:center;">
			<h1 style="color:red;"><?php echo $heading;?></h1>
			<p><?php echo $display;?></p>
			<a href="<?php echo $href ?>">Return</a>
		</div>
	</body>	
</html>
